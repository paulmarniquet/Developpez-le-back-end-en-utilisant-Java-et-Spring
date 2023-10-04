package com.example.chatop.repository;

import com.example.chatop.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    Optional<Images> findByName(String name);
}