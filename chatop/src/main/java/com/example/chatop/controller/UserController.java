package com.example.chatop.controller;

import com.example.chatop.dto.CredentialDto;
import com.example.chatop.dto.JwtTokenDto;
import com.example.chatop.dto.RegisterDto;
import com.example.chatop.entity.User;
import com.example.chatop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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
    @Operation(summary = "Login a user")
    @Parameter(name = "request", required = true, description = "The credential object")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Logged in with success"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody CredentialDto request) {
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
    @Operation(summary = "Register a new user")
    @Parameter(name = "request", required = true, description = "The register object")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Registered with success"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request"),
    })
    public ResponseEntity<JwtTokenDto> register(@Valid @RequestBody RegisterDto request) {
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
    @Operation(summary = "Get data of the current user")
    @Parameter(name = "request", required = true, description = "The http request")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Get data of the current user"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
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
    @Operation(summary = "Get data of a user")
    @Parameter(name = "id", required = true, description = "The id of the user")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Get data of a user"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        try {
            Optional<User> userId = userService.getUser(id);
            return ResponseEntity.ok(userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}