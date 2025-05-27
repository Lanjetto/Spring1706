package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.entity.MessageEntity;
import com.nexign.springMessageSender.model.Destination;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class MessageSender {

    private MessageRepository messageRepository;

    @Autowired
    public MessageSender(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public String sendMessage(Message message, Destination destination) {
        MessageEntity messageEntity = new MessageEntity(message.getBody(),destination.getCity());
        messageRepository.save(messageEntity);
        return "Message " + message.getBody()
                + " delivered to " + destination.getCity();
    }


    public List<MessageEntity> getMessages() {
        return messageRepository.findAll();
    }

    public List<MessageEntity> getDestinationMessage(String city) {
        return messageRepository.findByDestinationLike(city);
    }
}
