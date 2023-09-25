package com.example.chatop.user;

import com.example.chatop.dto.CredentialDto;
import com.example.chatop.dto.JwtTokenDto;
import com.example.chatop.dto.RegisterDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody CredentialDto request) {
        JwtTokenDto userDto = userService.login(request);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtTokenDto> register(@RequestBody RegisterDto request) {
        JwtTokenDto newUser = userService.register(request);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/me")
    public ResponseEntity<User> me(HttpServletRequest request) {
        User user = userService.me(request);
        return ResponseEntity.ok(user);
    }
}