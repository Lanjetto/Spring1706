package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
//    @Autowired
    private Destination destination;
    private IMessage message;

    @Autowired
    public MessageSender(Destination destination, Message message) {
        this.destination = destination;
        this.message = message;
    }

    public MessageSender() {
    }

    public Destination getDestination() {
        return destination;
    }

    public IMessage getMessage() {
        return message;
    }

    public void sendMessage() {
        System.out.println("Message " + message.getBody()
                + " delivered to " + destination.getCity() + " "
                + destination.getTime());
    }
}
