package com.solvd.aviatracker.kafka.property;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@RequiredArgsConstructor
@Getter
@ConfigurationProperties(prefix = "spring.kafka.streams")
public class KfProperties {

    private final String bootstrapServers;
    private final String applicationId;
    private final String inputTopic;
    private final String outputTopic;
    private final String groupId;

}
