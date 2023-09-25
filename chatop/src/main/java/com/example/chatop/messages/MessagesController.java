package com.example.chatop.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    /**
     * Post - Create a new message
     *
     * @return The rental object saved
     */
    @PostMapping("/messages")
    public Messages saveMessage(@RequestBody Messages request) {
        return messagesService.saveMessage(request.getMessage(), request.getUser_id(), request.getRental_id());
    }
}