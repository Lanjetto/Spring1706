package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.IMessage;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageRepository;
import com.nexign.springMessageSender.repository.MessageSenderDAO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageSender {

    private Destination destination;
    private MessageRepository messageRepository;

    // IoC
    public MessageSender(Destination destination, MessageRepository messageRepository) {
        this.destination = destination;
        this.messageRepository = messageRepository;
    }

    public Destination getDestination() {
        return destination;
    }

    public void sendMessage(Message message) {
        messageRepository.save(message);
    }

    public void sendMessage(Message... messages) {
        Arrays.stream(messages)
                .peek(System.out::println)
                .forEach(m -> messageRepository.save(m));
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow();
    }

    public Message getMessageByBody(String s) {
        return messageRepository.findByBodyLike(s);
    }
}
