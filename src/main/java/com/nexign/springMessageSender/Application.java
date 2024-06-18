package com.nexign.springMessageSender;


import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class);

//        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
//
//        List<Message> messages = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            messages.add(applicationContext.getBean(Message.class));
//        }
//
//        messages.forEach(messageSender::sendMessage);

    }
}
