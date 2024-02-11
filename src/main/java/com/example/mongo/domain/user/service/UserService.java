package com.example.mongo.domain.user.service;

import com.example.mongo.domain.user.dto.request.UserSaveReq;
import com.example.mongo.domain.user.dto.response.UserSaveRes;
import com.example.mongo.domain.user.entity.User;
import com.example.mongo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSaveRes save(UserSaveReq req) {
        User user = User.builder()
            .name(req.getName())
            .build();

        User saveUser = userRepository.save(user);

        return UserSaveRes.to(saveUser.getName());
    }
}
