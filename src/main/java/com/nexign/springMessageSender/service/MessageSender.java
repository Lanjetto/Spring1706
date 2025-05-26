package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.Destination;

public class MessageSender {

    private Destination destination;


    public MessageSender(Destination destination) {
        this.destination = destination;

    }

    public Destination getDestination() {
        return destination;
    }

}
