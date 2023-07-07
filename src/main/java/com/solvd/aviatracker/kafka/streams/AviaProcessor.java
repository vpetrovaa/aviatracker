package com.solvd.aviatracker.kafka.streams;

import com.solvd.aviatracker.domain.Airport;
import com.solvd.aviatracker.domain.Message;
import com.solvd.aviatracker.kafka.property.KfProperties;
import com.solvd.aviatracker.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class AviaProcessor {

    private final KfProperties kfProperties;
    private final AirportRepository airportRepository;

    @Bean
    public KStream<String, Message> stream(StreamsBuilder builder) {
        Serde<String> stringSerde = Serdes.String();
        Serde<Message> messageSerde = new JsonSerde<>(Message.class);
        KStream<String, Message> kStream = builder
                .stream(kfProperties.getInputTopic(),
                        Consumed.with(stringSerde, messageSerde))
                .filter((key, value) -> value.getStatus() == Message.Status.BROKEN_DOWN)
                .map((key, value) -> {
                    Airport airport = airportRepository.findNearestByLongitudeAndLatitude(
                            value.getLatitude(), value.getLongitude());
                    value.setAirportLongitude(airport.getLongitude());
                    value.setAirportLatitude(airport.getLatitude());
                    value.setId(UUID.randomUUID().toString());
                    return KeyValue.pair(value.getId(), value);
                })
                .groupByKey(Grouped.with(stringSerde, messageSerde))
                .aggregate(Message::new,
                        (key, value, aggregate) -> aggregate.process(value),
                        Materialized.with(stringSerde, messageSerde))
                .toStream();
        log.info("Message received -> {}", kStream);
        kStream.to(kfProperties.getOutputTopic(),
                Produced.with(stringSerde, messageSerde));
        return kStream;
    }

}
