package com.example.mongo.domain.chat.service;

import com.example.mongo.domain.chat.dto.request.ChatCreateReq;
import com.example.mongo.domain.chat.dto.response.ChatCreateRes;
import com.example.mongo.domain.chat.entity.Chat;
import com.example.mongo.domain.chat.event.ChatEvent;
import com.example.mongo.domain.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ApplicationEventPublisher publisher;
    private final ChatRepository chatRepository;

    public ChatCreateRes getChat(String chatId) {
        Chat chat = chatRepository.findById(chatId).get();

        return ChatCreateRes.to(chat);
    }

    public ChatCreateRes sendChat(ChatCreateReq req) {
        Chat chat = Chat.builder()
            .sender(req.getSender())
            .message(req.getMessage())
            .isDeleted(req.getIsDeleted())
            .build();
        Chat saveChat = chatRepository.save(chat);

        ChatEvent chatEvent = ChatEvent.builder().senderId(saveChat.getSender())
            .message(saveChat.getMessage())
            .build();

        publisher.publishEvent(chatEvent);

        return ChatCreateRes.to(saveChat);
    }

    @Transactional
    public ChatCreateRes updateChat(String chatId) {
        Chat chat = chatRepository.findById(chatId).get();
        chat.updateDeleted();
        long a = 1/0;
        return ChatCreateRes.to(chat);
    }

    public void deleteChat(String chatId) {
        Chat chat = chatRepository.findById(chatId).get();
        chatRepository.delete(chat);
    }
}
