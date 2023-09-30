package com.example.chatop.user;

import com.example.chatop.dto.CredentialDto;
import com.example.chatop.dto.JwtTokenDto;
import com.example.chatop.dto.RegisterDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Authentification Controller", description = "Login, register and get user")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    /**
     * Post - Login
     * @param request The credential object
     * @return ResponseEntity<JwtTokenDto>
     */
    @PostMapping("/auth/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody CredentialDto request) {
        try {
            JwtTokenDto userDto = userService.login(request);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Post - Register
     * @param request The register object
     * @return ResponseEntity<JwtTokenDto>
     */
    @PostMapping("/auth/register")
    public ResponseEntity<JwtTokenDto> register(@RequestBody RegisterDto request) {
        try {
            JwtTokenDto newUser = userService.register(request);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Get - Me
     * @param request The http request
     * @return ResponseEntity<User>
     */
    @GetMapping("auth/me")
    public ResponseEntity<User> me(HttpServletRequest request) {
        try {
            User user = userService.me(request);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Get - Get user
     * @return The user object
     */
    @GetMapping("user/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        try {
            Optional<User> userId = userService.getUser(id);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}