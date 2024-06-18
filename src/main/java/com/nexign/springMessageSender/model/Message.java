package com.nexign.springMessageSender.model;

import jakarta.persistence.*;

import java.lang.annotation.Target;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "message")
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
