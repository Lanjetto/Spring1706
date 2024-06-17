package com.nexign.springMessageSender.config;

import com.nexign.springMessageSender.model.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nexign.springMessageSender")
public class BeanConfig {

    @Bean
    public Message getMessage() {
        return new Message();
    }
}
