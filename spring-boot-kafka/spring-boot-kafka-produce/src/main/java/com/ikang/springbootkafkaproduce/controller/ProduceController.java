package com.ikang.springbootkafkaproduce.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    private static final String TOPIC_NAME = "test2";

    private final KafkaTemplate kafkaTemplate;

    public ProduceController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping("send")
    public String send(String message) {
        ListenableFuture send = kafkaTemplate.send(TOPIC_NAME, message);

        return "success";
    }
}
