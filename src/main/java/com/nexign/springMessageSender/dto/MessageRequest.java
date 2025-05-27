package com.nexign.springMessageSender.dto;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;

public class MessageRequest {
    private Message message;
    private Destination destination;

    public MessageRequest() {
    }

    public MessageRequest(Message message, Destination destination) {
        this.message = message;
        this.destination = destination;
    }

    public Message getMessage() {
        return message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
