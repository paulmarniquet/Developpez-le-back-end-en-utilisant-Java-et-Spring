package com.example.chatop.rentals;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

import com.example.chatop.dto.rentalDto;
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

    public void saveRental(Rentals rental) {
        Rentals newRental = rental.getClass().cast(rental);
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