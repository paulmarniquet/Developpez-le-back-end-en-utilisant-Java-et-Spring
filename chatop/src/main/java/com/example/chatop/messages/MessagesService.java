package com.example.chatop.messages;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    public Messages saveMessage(String message, int userId, int rentalId) {
        Messages messages = new Messages();
        messages.setMessage(message);
        messages.setUser_id(userId);
        messages.setRental_id(rentalId);
        Timestamp date = new Timestamp(new Date().getTime());
        messages.setCreated_at(date);
        messages.setUpdated_at(date);
        return messagesRepository.save(messages);
    }
}