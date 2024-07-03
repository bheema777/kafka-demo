package com.honeybadger.kafka.rest;

import com.honeybadger.kafka.payload.Student;
import com.honeybadger.kafka.producer.KafkaJsonProducer;
import com.honeybadger.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
       kafkaProducer.sendMessage(message);
       return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendStudent(@RequestBody Student student){
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
