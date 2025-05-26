package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.dao.MessageDAO;
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
    private MessageDAO messageDAO;

    @Autowired
    public MessageSender(Destination destination, Message message, MessageDAO messageDAO) {
        this.destination = destination;
        this.message = message;
        this.messageDAO = messageDAO;
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

        messageDAO.send(message,destination);
    }
}
