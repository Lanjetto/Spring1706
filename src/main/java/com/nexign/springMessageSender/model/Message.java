package com.nexign.springMessageSender.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class Message implements IMessage {

    @Value(value = "${random.strings}")
    private String[] randomStrings;
    private String body;

    @PostConstruct
    public void init() {
        Random random = new Random();
        int i = random.nextInt(randomStrings.length);
        this.body =randomStrings[i];
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "body='" + body + '\'' +
                '}';
    }
}
