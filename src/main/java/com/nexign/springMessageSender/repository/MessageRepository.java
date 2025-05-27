package com.nexign.springMessageSender.repository;

import com.nexign.springMessageSender.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByDestinationLike(String city);
}
