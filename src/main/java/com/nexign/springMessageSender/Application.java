package com.nexign.springMessageSender;


import com.nexign.springMessageSender.config.BeanConfig;
import com.nexign.springMessageSender.service.MessageSender;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {

//        ApplicationContext context = new ApplicationContext();
//        BeanFactory beanFactory = new BeanFactory(context);
//        context.setFactory(beanFactory);
//
//        MessageSender messageSender = context.getBean(MessageSender.class);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage();

        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        System.out.println("Press enter to exit ....");
        System.in.read();


    }
}
