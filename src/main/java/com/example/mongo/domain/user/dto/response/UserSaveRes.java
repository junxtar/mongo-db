package com.example.mongo.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRes {

    private String name;

    @Builder
    private UserSaveRes(String name) {
        this.name = name;
    }

    public static UserSaveRes to(String name) {
        return UserSaveRes.builder()
            .name(name)
            .build();
    }
}
