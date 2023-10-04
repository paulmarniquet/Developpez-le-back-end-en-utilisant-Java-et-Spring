package com.example.chatop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class rentalDto {

    @NotBlank
    private String name;

    @NotNull
    private String surface;

    @NotNull
    private String price;

    @NotNull
    private MultipartFile picture;

    @NotBlank
    private String description;

    private String owner_id;
}
