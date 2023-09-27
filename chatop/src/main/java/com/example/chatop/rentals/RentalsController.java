package com.example.chatop.rentals;

import com.example.chatop.dto.rentalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class RentalsController {

    @Autowired
    private RentalsService rentalService;

    /**
     * Read - Get all rentals
     *
     * @return - An Iterable object of Rentals
     */
    @GetMapping("/rentals")
    public ResponseEntity<RentalResponse> getRentals() {
        try {
            List<Rentals> rentals = new ArrayList<>();
            rentalService.getRentals().forEach(rentals::add);
            RentalResponse rentalResponse = new RentalResponse(rentals);
            return ResponseEntity.ok(rentalResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    /**
     * Read - Get a rental by id
     *
     * @param id The id of the rental
     * @return A rental object
     */
    @GetMapping("/rentals/{id}")
    public ResponseEntity<Optional<Rentals>> getRental(@PathVariable Long id) {
        try {
            Optional<Rentals> rentalId = rentalService.getRental(id);
            return ResponseEntity.ok(rentalId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Post - Create a new rental
     *
     * @return The rental object saved
     */
    @PostMapping("/rentals")
    public ResponseEntity<String> saveRental(Rentals rental) {
        try {
            rentalService.saveRental(rental);
            return ResponseEntity.ok("Rental created !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    /**
     * Put - Update a rental
     *
     * @param id     The id of the rental to update
     * @param rental The rental object updated
     * @return The rental updated
     */
    @PutMapping("/rentals/{id}")
    public ResponseEntity<String> updateRental(@PathVariable Long id, Rentals rental) {
        try {
            rentalService.updateRental(id, rental);
            return ResponseEntity.ok("Rental updated !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Delete - Delete a rental
     *
     * @param id The id of the rental to delete
     * @return HTTP status 200 if the operation is done successfully
     */
    @DeleteMapping("/rentals/delete/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}