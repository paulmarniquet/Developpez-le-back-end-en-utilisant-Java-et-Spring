package com.example.chatop.repository;

import com.example.chatop.entities.Rentals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends CrudRepository<Rentals, Long> {}