package com.nexign.springMessageSender.model;


import com.nexign.springMessageSender.annotations.Inject;
import org.springframework.stereotype.Component;

@Component
public class Destination {
    private String city = "The wall";
//    @Inject
    private Time time;

    public Destination(Time time) {
        this.time = time;
    }
//    public Destination(String city) {
//        this.city = city;
//    }

    public String getCity() {
        return city;
    }

    public Time getTime() {
        return time;
    }
}