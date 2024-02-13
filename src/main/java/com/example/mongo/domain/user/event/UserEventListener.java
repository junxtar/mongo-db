package com.example.mongo.domain.user.event;

import com.example.mongo.domain.chat.event.ChatEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventListener {

    @EventListener
    public void sendPush(ChatEvent chatEvent) {
        log.info("User 메시지 알림이 울렸습니다! {}", chatEvent.getMessage());
    }

}
