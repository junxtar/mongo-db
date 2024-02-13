package com.example.mongo.domain.chat.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ChatEventListener {
    @EventListener
    public void sendPush(ChatEvent chatEvent) {
        log.info("Message = {}, Sender = {}", chatEvent.getMessage(), chatEvent.getSenderId());
    }

}
