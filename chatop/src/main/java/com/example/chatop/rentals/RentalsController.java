package com.example.chatop.rentals;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name = "Rentals Controller", description = "Get, create, update and delete rentals")
@RestController
@RequestMapping("/api")
public class RentalsController {

    @Autowired
    private RentalsService rentalService;

    /**
     * Read - Get all rentals
     * @return A list of rentals
     */
    @GetMapping("/rentals")
    @Operation(summary = "Get all rentals")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Get all rentals"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
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
     * Read - Get one rental
     * @param id The id of the rental
     * @return ResponseEntity<Optional < Rentals>>
     */
    @GetMapping("/rentals/{id}")
    @Operation(summary = "Get a specific rental")
    @Parameter(name = "id", required = true, description = "The id of the rental")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Get a specific rental"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
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
     * @param rental The rental object
     * @return ResponseEntity<String>
     */
    @PostMapping("/rentals")
    @Operation(summary = "Create a new rental")
    @Parameter(name = "rental", required = true, description = "The rental object")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Created a new rental"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
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
     * @param id     The id of the rental
     * @param rental The rental object
     * @return ResponseEntity<String>
     */
    @PutMapping("/rentals/{id}")
    @Operation(summary = "Update a rental")
    @Parameters({
            @Parameter(name = "id", required = true, description = "The id of the rental"),
            @Parameter(name = "rental", required = true, description = "The rental object")
    })
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Rental updated !"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
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
     * @param id The id of the rental
     */
    @DeleteMapping("/rentals/delete/{id}")
    @Operation(summary = "Delete a rental")
    @Parameter(name = "id", required = true, description = "The id of the rental")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }
}