package com.nexign.springMessageSender.controller;

import com.nexign.springMessageSender.dto.MessageRequest;
import com.nexign.springMessageSender.entity.MessageEntity;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageSender messageSender;

    @GetMapping
    public ResponseEntity<List<MessageEntity>> getMessages(){
       return ResponseEntity.ok(messageSender.getMessages());
    }

    @GetMapping("{city}")
    public ResponseEntity<List<MessageEntity>> getDestinationMessages(@PathVariable(name = "city") String city){
        return ResponseEntity.ok(messageSender.getDestinationMessage(city));
    }

    @PostMapping("post/{messageId}/{messageText}")
    public String sendMessageFromUrl(@PathVariable(name = "messageId") Long messageId,
                                   @PathVariable(name = "messageText") String messageText,
                                   @RequestParam(name = "city") String city) {
        Message message = new Message(messageId, messageText);
        Destination destination = new Destination(city);
        return messageSender.sendMessage(message, destination);
    }

    @PostMapping("post")
    public String sendMessage(@RequestBody MessageRequest messageRequest) {
        Message message = messageRequest.getMessage();
        Destination destination = messageRequest.getDestination();
        return messageSender.sendMessage(message, destination);
    }
}
