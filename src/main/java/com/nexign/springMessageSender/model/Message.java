package com.nexign.springMessageSender.model;


public class Message {

    private Long id;

    private String body;

    public Message(String body) {
        this.body = body;
    }

    public Message() {
    }

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
