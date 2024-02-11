package com.example.mongo.domain.chat.controller;

import com.example.mongo.domain.chat.dto.request.ChatCreateReq;
import com.example.mongo.domain.chat.dto.response.ChatCreateRes;
import com.example.mongo.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;
    @PostMapping
    public ResponseEntity<ChatCreateRes> sendChat(@RequestBody ChatCreateReq req) {
        return ResponseEntity.ok(chatService.sendChat(req));
    }
}
