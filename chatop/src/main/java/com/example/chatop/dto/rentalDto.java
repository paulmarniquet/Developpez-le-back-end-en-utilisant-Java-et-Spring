package com.example.chatop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class rentalDto {
    private String name;
    private String surface;
    private String price;
    private String picture;
    private String description;
    private String owner_id;
}
