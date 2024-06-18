package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageSenderDAO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageSender {

    private IMessage message;
    private Destination destination;
    private MessageSenderDAO messageSenderDAO;

    // IoC
    public MessageSender(Message message, Destination destination, MessageSenderDAO messageSenderDAO) {
        this.message = message;
        this.destination = destination;
        this.messageSenderDAO = messageSenderDAO;
    }

    public IMessage getMessage() {
        return message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void sendMessage() {
        messageSenderDAO.sendMessage(message.getBody());
    }

    public void sendMessage(Message... messages) {
        Arrays.stream(messages)
                .peek(System.out::println)
                .forEach(m -> messageSenderDAO.sendMessage(m.getBody()));
    }
}
