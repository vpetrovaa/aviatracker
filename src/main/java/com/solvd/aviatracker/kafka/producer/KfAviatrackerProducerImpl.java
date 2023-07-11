package com.solvd.aviatracker.kafka.producer;

import com.solvd.aviatracker.domain.Message;
import com.solvd.aviatracker.kafka.property.KfProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public final class KfAviatrackerProducerImpl implements KfProducer<Message> {

    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final KfProperties kfProperties;

    @Override
    public void sendMessage(final Message message) {
        kafkaTemplate.send(kfProperties.getInputTopic(), message);
    }

}
