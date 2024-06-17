package com.nexign.springMessageSender.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Message implements IMessage {

    @Value(value = "{strings}")
    private String[] randomStrings;
    private String body;

    public Message(String body) {
        this.body = body;
    }

    @PostConstruct
    public void init() {
        Random random = new Random();
        int i = random.nextInt(randomStrings.length);
        this.body =randomStrings[i];
    }

}
