package com.example.mongo.domain.chat.entity;

import com.example.mongo.domain.model.BaseEntity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat extends BaseEntity {

    @Id
    private String id;
    private Long sender;
    private String message;

    @Builder
    private Chat(Long sender, String message) {
        this.sender = sender;
        this.message = message;
    }
}
