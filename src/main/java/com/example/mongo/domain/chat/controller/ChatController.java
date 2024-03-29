package com.example.mongo.domain.chat.controller;

import com.example.mongo.domain.chat.dto.request.ChatCreateReq;
import com.example.mongo.domain.chat.dto.response.ChatCreateRes;
import com.example.mongo.domain.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/{chatId}")
    public ResponseEntity<ChatCreateRes> getChat(@PathVariable String chatId) {
        return ResponseEntity.ok(chatService.getChat(chatId));
    }
    @PostMapping
    public ResponseEntity<ChatCreateRes> sendChat(@RequestBody ChatCreateReq req) {
        return ResponseEntity.ok(chatService.sendChat(req));
    }
    @PutMapping("/{chatId}")
    public ResponseEntity<ChatCreateRes> updateChat(@PathVariable String chatId) {
        return ResponseEntity.ok(chatService.updateChat(chatId));
    }

    @DeleteMapping("/{chatId}")
    public ResponseEntity<Void> deleteChat(@PathVariable String chatId) {
        chatService.deleteChat(chatId);
        return ResponseEntity.noContent().build();
    }
}
