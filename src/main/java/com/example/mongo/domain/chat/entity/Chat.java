package com.example.mongo.domain.chat.entity;

import com.example.mongo.domain.model.MongoBaseEntity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat extends MongoBaseEntity {

    @Id
    private String id;
    private Long sender;
    private String message;
    private Boolean isDeleted;

    @Builder
    private Chat(Long sender, String message, Boolean isDeleted) {
        this.sender = sender;
        this.message = message;
        this.isDeleted = isDeleted;
    }

    public void updateDeleted() {
        this.isDeleted = !this.isDeleted;
    }
}
