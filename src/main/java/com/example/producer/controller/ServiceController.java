package com.example.produser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ServiceController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{message}")
    public String getMessageToTopic(@PathVariable String message) {
        try {
            kafkaTemplate.send("My_topic", "Hello");
        } catch (Exception e) {
            return "Сообщение не опубликовано";
        }
        return "Сообщение опубликовано";
    }
}
