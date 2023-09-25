package com.example.chatop.rentals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController @RequestMapping("/api")
public class RentalsController {

    @Autowired
    private RentalsService userService;

    /**
     * Read - Get all rentals
     *
     * @return - An Iterable object of Rentals
     */
    @GetMapping("/rentals")
    public Iterable<Rentals> getRentals() {
        return userService.getRentals();
    }

    /**
     * Read - Get a rental by id
     *
     * @param id The id of the rental
     * @return A rental object
     */
    @GetMapping("/rentals/{id}")
    public Optional<Rentals> getRental(@PathVariable Long id) {
        return userService.getRental(id);
    }

    /**
     * Post - Create a new rental
     *
     * @return The rental object saved
     */
    @PostMapping("/rentals")
    public Rentals saveRental(Rentals rental) {
        return userService.saveRental(rental);
    }

    /**
     * Put - Update a rental
     *
     * @param id     The id of the rental to update
     * @param rental The rental object updated
     * @return The rental updated
     */
    @PutMapping("/rentals/{id}")
    public Rentals updateRental(@PathVariable Long id, Rentals rental) {
        return userService.updateRental(id, rental);
    }

    /**
     * Delete - Delete a rental
     *
     * @param id The id of the rental to delete
     * @return HTTP status 200 if the operation is done successfully
     */
    @DeleteMapping("/rentals/delete/{id}")
    public void deleteRental(@PathVariable Long id) {
        userService.deleteRental(id);
    }

}