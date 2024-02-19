package com.example.mongo.domain.model;

import jakarta.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@MappedSuperclass
public abstract class MongoBaseTimeEntity implements Serializable {

    @CreatedDate
    @Field(name = "create_at")
    private String createdAt = ZonedDateTime.now().toString();

    @LastModifiedDate
    @Field(name="modified_at")
    private String modifiedAt = ZonedDateTime.now().toString();
}
