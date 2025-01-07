package com.example.service2;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// Project B - Server B
@Service
public class MessageService {

    private final RestTemplate restTemplate;

    public MessageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMessageFromProjectA() {
        String url = "http://localhost:8080/message";
        return restTemplate.getForObject(url, String.class);
    }
}
