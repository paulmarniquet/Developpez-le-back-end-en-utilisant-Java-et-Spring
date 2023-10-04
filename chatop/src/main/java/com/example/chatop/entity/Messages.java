package com.example.chatop.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "messages")
public class Messages {

    @Id

    @Column(name="rental_id")
    private Integer rental_id;

    @Column(name="user_id")
    private Integer user_id;

    @Column (name="message")
    private String message;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="updated_at")
    private Timestamp updated_at;
}