package com.example.chatop.images;

import jakarta.annotation.Resource;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = Images.builder()
                .name(imageFile.getOriginalFilename())
                .type(imageFile.getContentType())
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();
        imageRepository.save(imageToSave);
        return "Image uploaded successfully : " + imageFile.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName) throws DataFormatException, IOException {
        Optional<Images> dbImage = imageRepository.findByName(imageName);
        return ImageUtils.decompressImage(dbImage.orElseThrow(() -> new ContextedRuntimeException("Image not found")).getImageData());
    }
}