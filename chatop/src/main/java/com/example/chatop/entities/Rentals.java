package com.example.chatop.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rentals")
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="surface")
    private Integer surface;

    @Column(name="price")
    private Integer price;

    @Column(name="picture")
    private String picture;

    @Column(name="description")
    private String description;

    @Column (name="owner_id")
    private Integer owner_id;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;
}