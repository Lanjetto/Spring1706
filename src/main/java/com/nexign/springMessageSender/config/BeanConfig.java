package com.nexign.springMessageSender.config;

import com.nexign.springMessageSender.model.Time;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.nexign.springMessageSender")
@PropertySource("classpath:application.yml")

public class BeanConfig {

    @Bean
    public Time getTime() {
        return new Time();
    }

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:h2:mem:testdb;" +
                        "DB_CLOSE_DELAY=-1;" +
                        "DB_CLOSE_ON_EXIT=false;" +
                        "DATABASE_TO_UPPER=false",
                "sa",
                ""
        );
    }
}
