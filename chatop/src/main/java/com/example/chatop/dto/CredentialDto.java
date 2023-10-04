package com.example.chatop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CredentialDto (
        @Email(message = "Invalid email address")
        String email,
        @NotNull(message = "Password cannot be blank")
        char[] password)
{}