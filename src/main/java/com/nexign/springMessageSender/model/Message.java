package com.nexign.springMessageSender.model;

import lombok.AllArgsConstructor;
import lombok.ToString;


@ToString

public class Message implements IMessage {
    private Long id;
    private String body;

    public Message() {
    }

    public Message(Long id, String body) {
        this.id = id;
        this.body = body;
    }

    public Message(String body) {
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }

}
