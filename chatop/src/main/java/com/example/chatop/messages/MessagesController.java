package com.example.chatop.messages;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Message Controller", description = "Send a message")
@RestController @RequestMapping("/api")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    /**
     * Send a message
     * @param request The message object
     * @return ResponseEntity<String>
     */
    @PostMapping("/messages")
    @Operation(summary = "Send a message on a rental")
    @Parameter(name = "request", required = true, description = "The message object")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Message send with success"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    public ResponseEntity<String> saveMessage(@RequestBody Messages request) {
        try {
            messagesService.saveMessage(request.getMessage(), request.getUser_id(), request.getRental_id());
            return ResponseEntity.ok("Message send with success");
        }
        catch (Exception e) {
            if (request.getMessage() == null || request.getUser_id() == null || request.getRental_id() == null)
                return ResponseEntity.status(400).build();
            else
                return ResponseEntity.status(401).build();
        }
    }
}