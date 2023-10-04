package com.example.chatop.rentals;

import java.net.URI;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import com.example.chatop.dto.rentalDto;
import com.example.chatop.images.ImageController;
import com.example.chatop.images.ImageRepository;
import com.example.chatop.images.ImageService;
import com.example.chatop.images.Images;
import org.apache.commons.io.input.BufferedFileChannelInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import lombok.Data;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


@Data
@Service
public class RentalsService {

    @Autowired
    private RentalsRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    public Optional<Rentals> getRental(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<Rentals> getRentals() {
        return userRepository.findAll();
    }

    public void deleteRental(final Long id) {
        userRepository.deleteById(id);
    }

    public void saveRental(rentalDto rental) {
        Rentals newRental = new Rentals();
        newRental.setName(rental.getName());
        newRental.setSurface(Integer.valueOf(rental.getSurface()));
        newRental.setPrice(Integer.valueOf(rental.getPrice()));
        newRental.setDescription(rental.getDescription());
        newRental.setOwner_id(Integer.valueOf(rental.getOwner_id()));
        Timestamp date = new Timestamp(new Date().getTime());
        newRental.setCreated_at(date);
        newRental.setUpdated_at(date);

        MultipartFile file = rental.getPicture();
        ImageService imageService = new ImageService(imageRepository);
        try {
            imageService.uploadImage(file);
        } catch (Exception e) {
            System.out.println(e);
        }
        newRental.setPicture("http://localhost:9099/image/" + file.getOriginalFilename());
        userRepository.save(newRental);
    }

    public Rentals updateRental(Long id, Rentals rental) {
        Optional<Rentals> rentalId = userRepository.findById(id);
        Rentals newRental = rentalId.get();
        newRental.setName(rental.getName());
        newRental.setSurface(rental.getSurface());
        newRental.setPrice(rental.getPrice());
        newRental.setDescription(rental.getDescription());
        newRental.setOwner_id(rentalId.get().getOwner_id());
        Timestamp date = new Timestamp(new Date().getTime());
        newRental.setUpdated_at(date);
        return userRepository.save(newRental);
    }
}