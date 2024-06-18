package com.nexign.springMessageSender.controller;


import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/form")
public class FormController {

    @Autowired
    private MessageSender messageSender;

    @GetMapping
    public String getForm() {
        return "messageForm";
    }

    @PostMapping("/submit-message")
    public String submitMessage(@RequestParam("message") String message, Model model) {
        Message message1 = new Message(message);
        messageSender.sendMessage(message1);
        model.addAttribute("notification", "Сообщение отправлено успешно!");
        return "messageForm";
    }
}
