package com.nexign.springMessageSender;


import com.nexign.springMessageSender.config.BeanConfig;
import com.nexign.springMessageSender.factory.BeanFactory;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ApplicationContext();
//        BeanFactory beanFactory = new BeanFactory(applicationContext);
//        applicationContext.setBeanFactory(beanFactory);

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSender messageSender = applicationContext.getBean(MessageSender.class);
        messageSender.sendMessage();
    }
}
