package com.example.chatop.user;

import com.example.chatop.JwtTokenProvider;
import com.example.chatop.dto.CredentialDto;
import com.example.chatop.dto.JwtTokenDto;
import com.example.chatop.dto.RegisterDto;
import com.example.chatop.dto.userDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.CharBuffer;

@Data
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public JwtTokenDto login(CredentialDto request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(CharBuffer.wrap(request.password()), passwordEncoder.encode(user.getPassword()))) {
            userDto userDto = new userDto(user.getEmail(), user.getPassword());
            return new JwtTokenDto(new JwtTokenProvider().generateToken(userDto));
        } else {
            throw new RuntimeException("Password is incorrect");
        }
    }

    public JwtTokenDto register(RegisterDto request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("User already exists");
        } else {
            User user = new User();
            user.setEmail(request.email());
            user.setName(request.name());
            user.setRental_id(0);
            user.setPassword(String.valueOf(CharBuffer.wrap(request.password())));
            userRepository.save(user);
            userDto userDto = new userDto(user.getEmail(), user.getPassword());
            return new JwtTokenDto(new JwtTokenProvider().generateToken(userDto));
        }
    }


    public String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public User me(HttpServletRequest request) {
        String token = extractTokenFromRequest(request);
        String email = new JwtTokenProvider().getUsernameFromToken(token);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}