package com.example.chatop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CredentialDto (
        @Email(message = "Invalid email address")
        String email,
        @NotBlank(message = "Password cannot be blank")
        String password)
{}