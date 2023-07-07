package com.solvd.aviatracker.kafka.consumer;

import com.solvd.aviatracker.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class KfAviatrackerConsumerImpl implements KfConsumer<Message> {

    @KafkaListener(topics = "${spring.kafka.streams.output-topic}",
            groupId = "${spring.kafka.streams.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void receive(final Message message) {
        log.info("Message transformed into -> {}", message);
    }

}
