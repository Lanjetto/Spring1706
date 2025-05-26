package com.nexign.springMessageSender;


import com.nexign.springMessageSender.config.BeanConfig;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

//        ApplicationContext context = new ApplicationContext();
//        BeanFactory beanFactory = new BeanFactory(context);
//        context.setFactory(beanFactory);
//
//        MessageSender messageSender = context.getBean(MessageSender.class);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage();


    }
}
