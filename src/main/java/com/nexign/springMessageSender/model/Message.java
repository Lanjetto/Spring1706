package com.nexign.springMessageSender.model;

import org.springframework.stereotype.Component;

@Component
public class Message implements IMessage {

    private Long id;

    private String body;

    public Message(String body) {
        this.id = 1L;
        this.body = body;
    }

    public Message() {
        this.body = "They are coming";
    }
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
