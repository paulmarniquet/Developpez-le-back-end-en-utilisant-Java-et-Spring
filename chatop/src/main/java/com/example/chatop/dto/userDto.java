package com.example.chatop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDto {
    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Password cannot be blank")
    private String password;
}
