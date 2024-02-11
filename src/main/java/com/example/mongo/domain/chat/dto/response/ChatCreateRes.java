package com.example.mongo.domain.chat.dto.response;

import com.example.mongo.domain.chat.entity.Chat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCreateRes {

    private Long sender;
    private String message;

    @Builder
    private ChatCreateRes(Long sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public static ChatCreateRes to(Chat chat) {
        return ChatCreateRes.builder()
            .sender(chat.getSender())
            .message(chat.getMessage())
            .build();
    }
}
