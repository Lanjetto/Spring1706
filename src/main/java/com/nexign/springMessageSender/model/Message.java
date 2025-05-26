package com.nexign.springMessageSender.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Message implements IMessage {

    private Long id;

    private String body;

    @Value("${messages.presets}")
    private String rawMessages;

    @PostConstruct
    public void init() {
        String[] messages = rawMessages.split(", ");
        Random random = new Random();
        this.body = messages[random.nextInt(messages.length)];

        System.out.println(body);
    }

//    public Message(String body) {
//        this.id = 1L;
//        this.body = body;
//    }

    @Override
    public String getBody() {
        return body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                '}';
    }
}
