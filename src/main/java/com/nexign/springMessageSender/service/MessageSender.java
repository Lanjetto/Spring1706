package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.annotation.Inject;
import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private IMessage message;
    private Destination destination;

    // IoC
    public MessageSender(Message message, Destination destination) {
        this.message = message;
        this.destination = destination;
    }

    public IMessage getMessage() {
        return message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void sendMessage() {
        System.out.println(message + " отправлено в " + destination);
    }
}
