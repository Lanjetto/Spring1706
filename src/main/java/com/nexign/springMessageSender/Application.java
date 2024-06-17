package com.nexign.springMessageSender;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;

public class Application {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();
        messageSender.sendMessage();
    }
}
