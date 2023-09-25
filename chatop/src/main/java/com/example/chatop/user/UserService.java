package com.example.chatop.user;

import com.example.chatop.dto.CredentialDto;
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
        User user = userRepository.findByEmail(request.login())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(CharBuffer.wrap(request.password()), passwordEncoder.encode(user.getPassword()))) {
            return userDto.ToUserDto(user);
        } else {
            throw new RuntimeException("Password is incorrect");
        }
    }
}