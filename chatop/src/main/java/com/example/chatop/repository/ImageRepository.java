package com.example.chatop.repository;

import com.example.chatop.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {
    Optional<Images> findByName(String name);
}