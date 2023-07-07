package com.solvd.aviatracker.service.impl;

import com.solvd.aviatracker.domain.Message;
import com.solvd.aviatracker.kafka.producer.KfProducer;
import com.solvd.aviatracker.service.AviatrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class AviatrackerServiceImpl implements AviatrackerService {

    private final KfProducer kfProducer;

    @Override
    public void send(final Message message) {
        kfProducer.sendMessage(message);
    }

}
