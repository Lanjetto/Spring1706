package com.nexign.springMessageSender;


import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.service.MessageSender;

public class Application {
    public static void main(String[] args) {
        MessageSender messageSender = BeanFactory.getInstance().getBean(MessageSender.class);
        messageSender.sendMessage();
    }
}
