package com.example.chatop.rentals;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends CrudRepository<Rentals, Long> {}