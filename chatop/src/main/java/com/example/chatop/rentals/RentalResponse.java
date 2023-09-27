package com.example.chatop.rentals;
import lombok.Getter;
import java.util.List;

@Getter
public class RentalResponse {
    private List<Rentals> rentals;

    public RentalResponse(List<Rentals> rentals) {
        this.rentals = rentals;
    }

    public RentalResponse() {
        this.rentals = null;
    }

    public void setRentals(List<Rentals> rentals) {
        this.rentals = rentals;
    }
}
