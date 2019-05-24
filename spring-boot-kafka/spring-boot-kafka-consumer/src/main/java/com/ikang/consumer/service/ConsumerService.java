package com.ikang.consumer.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {


    @KafkaListener(topics = "test2")
    public void processMessage(String content) {
        System.out.println("接收到消息：" + content);
    }
}
