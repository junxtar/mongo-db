package com.example.mongo.domain.chat.event;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatEvent {

    private String message;
    private Long senderId;

    @Builder
    private ChatEvent(String message, Long senderId) {
        this.message = message;
        this.senderId = senderId;
    }
}
