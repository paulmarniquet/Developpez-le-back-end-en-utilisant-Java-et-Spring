package com.example.chatop.rentals;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class RentalsService {

    @Autowired
    private RentalsRepository userRepository;

    public Optional<Rentals> getRental(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<Rentals> getRentals() {
        return userRepository.findAll();
    }

    public void deleteRental(final Long id) {
        userRepository.deleteById(id);
    }

    public Rentals saveRental(Rentals rental) {
        Rentals savedRental = userRepository.save(rental);
        return savedRental;
    }

    public Rentals updateRental(Long id, Rentals rental) {
        Rentals rentalId = userRepository.findById(id).get();
        rentalId = rental;
        Rentals savedRental = userRepository.save(rentalId);
        return savedRental;
    }
}