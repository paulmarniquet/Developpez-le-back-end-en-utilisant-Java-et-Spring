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

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Surface is mandatory")
    private String surface;

    @NotNull(message = "Price is mandatory")
    private String price;

    @NotNull(message = "Picture is mandatory")
    private MultipartFile picture;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private String owner_id;
}
