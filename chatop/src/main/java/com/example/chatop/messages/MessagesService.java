package com.example.chatop.messages;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return messagesRepository.save(messages);
    }
}