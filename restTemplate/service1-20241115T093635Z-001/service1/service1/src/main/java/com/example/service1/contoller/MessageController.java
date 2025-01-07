package com.example.service1.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Project A - Server A
@RestController
public class MessageController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Project A server port 8080 !";
    }
}
