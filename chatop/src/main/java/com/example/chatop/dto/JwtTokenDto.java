package com.example.chatop.dto;

import lombok.Getter;

@Getter
public class JwtTokenDto {
    private String token;

    public JwtTokenDto(String token) {
        this.token = token;
    }

    public JwtTokenDto() {}
}
