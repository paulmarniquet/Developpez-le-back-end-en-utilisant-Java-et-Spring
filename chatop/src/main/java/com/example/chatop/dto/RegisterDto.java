package com.example.chatop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDto (
        @Email(message = "Invalid email address")
        String email,

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Password cannot be blank")
        String password
) {}
