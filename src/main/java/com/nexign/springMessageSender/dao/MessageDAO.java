package com.nexign.springMessageSender.dao;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.model.Time;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MessageDAO {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute(
                """
                        create table messages(
                        id bigint primary key auto_increment,
                        message varchar(255) not null,
                        destination varchar(255) not null);
                        """
        );
    }

    public void send(IMessage message, Destination destination) {
        String text = message.getBody();
        String city = destination.getCity();
        System.out.println("message sended");
        jdbcTemplate.update("Insert into messages (message, destination) VALUES(?,?)", text, city);
    }
}
