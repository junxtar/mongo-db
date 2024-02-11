package com.example.mongo.domain.chat.dto.response;

import com.example.mongo.domain.chat.entity.Chat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCreateRes {

    private String id;
    private Long sender;
    private String message;
    private Boolean isDeleted;

    @Builder
    private ChatCreateRes(String id, Long sender, String message, Boolean isDeleted) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.isDeleted = isDeleted;
    }

    public static ChatCreateRes to(Chat chat) {
        return ChatCreateRes.builder()
            .id(chat.getId())
            .sender(chat.getSender())
            .message(chat.getMessage())
            .isDeleted(chat.getIsDeleted())
            .build();
    }
}
