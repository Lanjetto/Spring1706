package com.nexign.springMessageSender.model;

public class Destination {
    private String city;

    public Destination() {
    }

    public Destination(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}