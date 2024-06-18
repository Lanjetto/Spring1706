package com.nexign.springMessageSender.controller;


import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageSender messageSender;

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable(name = "id") Long id) {
        Message m = messageSender.getMessageById(id);
        return ResponseEntity.ok(m);
    }

    @GetMapping
    public ResponseEntity<Message> getMessageByBody(@RequestParam(name = "s") String s) {
        Message m = messageSender.getMessageByBody(s);
        return ResponseEntity.ok().body(m);
    }
}
