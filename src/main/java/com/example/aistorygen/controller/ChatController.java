package com.example.aistorygen.controller;

import com.example.aistorygen.dto.PromptRequest;
import com.example.aistorygen.service.ChatService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatGPTService){
        this.chatService = chatGPTService;
    }

    @PostMapping
    public String chat(@RequestBody PromptRequest promptRequest){
        return chatService.getChatResponse(promptRequest);
    }
}
