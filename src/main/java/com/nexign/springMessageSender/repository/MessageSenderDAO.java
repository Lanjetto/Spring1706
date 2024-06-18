package com.nexign.springMessageSender.repository;


import com.nexign.springMessageSender.model.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MessageSenderDAO {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
//        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("CREATE TABLE messages (id INT AUTO_INCREMENT PRIMARY KEY, text VARCHAR(255))");
    }

    public void sendMessage(String message) {
        jdbcTemplate.update("INSERT INTO messages (text) VALUES (?)", message);
        System.out.println(message + " отправлено");
    }

}
