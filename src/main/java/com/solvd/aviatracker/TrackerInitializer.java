package com.solvd.aviatracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TrackerInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(TrackerInitializer.class, args);
	}

}
