package com.solvd.aviatracker.kafka.streams.config;

import com.solvd.aviatracker.kafka.property.KfProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.Map;

@Configuration
@EnableKafka
@EnableKafkaStreams
@RequiredArgsConstructor
public class KafkaStreamsConfig {

    private final KfProperties kfProperties;

    @Bean(name =
            KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        return new KafkaStreamsConfiguration(Map.of(
                StreamsConfig.APPLICATION_ID_CONFIG,
                kfProperties.getApplicationId(),
                StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                kfProperties.getBootstrapServers(),
                StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName(),
                StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,
                Serdes.String().getClass().getName(),
                StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG,
                WallclockTimestampExtractor.class.getName()
        ));
    }

}