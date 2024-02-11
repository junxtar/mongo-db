package com.example.mongo.domain.chat.repository;

import com.example.mongo.domain.chat.entity.Chat;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {

    List<Chat> findBySender(Long sender);
}
