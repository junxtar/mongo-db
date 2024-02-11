package com.example.mongo.domain.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id
    private String id;
    private Long sender;
    private String message;
    private Boolean isDeleted;

    @CreatedDate
    @Column(updatable = false, name = "created_at")
    private String createdAt;

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
