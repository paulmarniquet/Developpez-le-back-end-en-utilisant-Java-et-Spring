package com.example.chatop.user;

import com.example.chatop.dto.CredentialDto;
import com.example.chatop.dto.RegisterDto;
import com.example.chatop.dto.userDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Data
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public userDto login(CredentialDto request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(CharBuffer.wrap(request.password()), passwordEncoder.encode(user.getPassword()))) {
            return userDto.ToUserDto(user);
        } else {
            throw new RuntimeException("Password is incorrect");
        }
    }

    public User register(RegisterDto request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        } else {
            User user = new User();
            user.setEmail(request.email());
            user.setName(request.name());
            user.setRental_id(0);
            user.setPassword(String.valueOf(CharBuffer.wrap(request.password())));
            userRepository.save(user);
            return user;
        }
    }
}