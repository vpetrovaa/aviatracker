package com.solvd.aviatracker.factory;

import com.solvd.aviatracker.domain.Message;

public class MessageFactory {

    public static Message generateMessage() {
        return Message.builder()
                .id("1")
                .airplaneId("1")
                .latitude(55.8373)
                .longitude(37.9854)
                .airportLongitude(0.0)
                .airportLatitude(0.0)
                .status(Message.Status.BROKEN_DOWN)
                .build();
    }

}
