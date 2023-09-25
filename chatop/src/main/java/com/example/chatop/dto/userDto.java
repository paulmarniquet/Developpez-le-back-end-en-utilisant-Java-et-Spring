package com.example.chatop.dto;

import com.example.chatop.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userDto {
    private String email;
    private String password;

    public static userDto ToUserDto(User user) {
        return new userDto(user.getEmail(), user.getPassword());
    }
}
