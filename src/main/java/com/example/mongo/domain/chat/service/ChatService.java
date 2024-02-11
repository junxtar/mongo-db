package com.example.mongo.domain.chat.service;

import com.example.mongo.domain.chat.dto.request.ChatCreateReq;
import com.example.mongo.domain.chat.dto.response.ChatCreateRes;
import com.example.mongo.domain.chat.entity.Chat;
import com.example.mongo.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatCreateRes sendChat(ChatCreateReq req) {
        Chat chat = Chat.builder()
            .sender(req.getSender())
            .message(req.getMessage())
            .build();
        Chat saveChat = chatRepository.save(chat);

        return ChatCreateRes.to(saveChat);
    }
}
