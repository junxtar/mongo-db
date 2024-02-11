package com.example.mongo.domain.chat.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCreateReq {

    private Long sender;
    private String message;
    private Boolean isDeleted;

}
