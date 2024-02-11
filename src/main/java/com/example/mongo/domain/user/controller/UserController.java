package com.example.mongo.domain.user.controller;

import com.example.mongo.domain.user.dto.request.UserSaveReq;
import com.example.mongo.domain.user.dto.response.UserSaveRes;
import com.example.mongo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserSaveRes> save(@RequestBody UserSaveReq req) {
        return ResponseEntity.ok(userService.save(req));
    }
}
