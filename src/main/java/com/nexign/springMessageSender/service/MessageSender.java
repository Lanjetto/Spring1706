package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageSenderDAO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageSender {

    private Destination destination;
    private MessageSenderDAO messageSenderDAO;

    // IoC
    public MessageSender(Destination destination, MessageSenderDAO messageSenderDAO) {
        this.destination = destination;
        this.messageSenderDAO = messageSenderDAO;
    }

    public Destination getDestination() {
        return destination;
    }

    public void sendMessage(Message message) {
        messageSenderDAO.sendMessage(message.getBody());
    }

    public void sendMessage(Message... messages) {
        Arrays.stream(messages)
                .peek(System.out::println)
                .forEach(m -> messageSenderDAO.sendMessage(m.getBody()));
    }
}
