package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;

public class MessageSender {
    private Message message = BeanFactory.getBean(Message.class);
    private Destination destination = BeanFactory.getBean(Destination.class);

    // IoC
//    public MessageSender(Message message, Destination destination) {
//        this.message = message;
//        this.destination = destination;
//    }

    public Message getMessage() {
        return message;
    }

    public Destination getDestination() {
        return destination;
    }

    public void sendMessage() {
        System.out.println(message + " отправлено в " + destination);
    }
}
