package com.example.service2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final MessageService messageService;

    public ClientController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/fetch-message")
    public String fetchMessage() {
        return "Message from Project A: " + messageService.getMessageFromProjectA();
    }
}
