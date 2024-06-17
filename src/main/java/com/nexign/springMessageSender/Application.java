package com.nexign.springMessageSender;


import com.nexign.springMessageSender.context.ApplicationContext;
import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.service.MessageSender;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        BeanFactory beanFactory = new BeanFactory(applicationContext);
        applicationContext.setBeanFactory(beanFactory);


        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage();
    }
}
