package com.example.chatop.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "rentals")
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="name")
    private String name;

    @NotNull
    @Column(name="surface")
    private Integer surface;

    @NotNull
    @Column(name="price")
    private Integer price;

    @NotNull
    @Column(name="picture")
    private String picture;

    @NotBlank
    @Column(name="description")
    private String description;

    @Column (name="owner_id")
    private Integer owner_id;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;
}