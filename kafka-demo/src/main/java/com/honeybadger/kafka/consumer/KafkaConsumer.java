package com.honeybadger.kafka.consumer;

import com.honeybadger.kafka.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class KafkaConsumer {
    //@KafkaListener(topics = "Topic1",groupId = "myGroup")
    public void readMessage(String msg){
        log.info(format("Consuming the message from Topic1 :: %s",msg));
    }

    @KafkaListener(topics = "Topic1",groupId = "myGroup")
    public void consumeStudent(Student student){
        log.info(format("Consuming the message from Topic1 :: %s",student.toString()));
    }
}
