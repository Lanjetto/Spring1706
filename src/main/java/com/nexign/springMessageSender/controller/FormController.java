package com.nexign.springMessageSender.controller;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    private MessageSender messageSender;

    @Autowired
    public FormController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping
    public String getForm() {
        return "messageForm";
    }
    @PostMapping("/submit-message")
    public String submitMessage(@RequestParam(name = "message") String message,
                                @RequestParam(name = "city") String city,
                                Model model) {
        Message message1 = new Message(message);
        Destination destination = new Destination(city);
        messageSender.sendMessage(message1, destination);
        model.addAttribute("notification", "Сообщение отправлено в " + city);
        return "messageForm";
    }
}
