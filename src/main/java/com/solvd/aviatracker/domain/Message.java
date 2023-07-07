package com.solvd.aviatracker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String id;
    private String airplaneId;
    private Double latitude;
    private Double longitude;
    private Double airportLongitude;
    private Double airportLatitude;
    private Status status;

    public enum Status {

        TOOK_OFF, LAND, BROKEN_DOWN

    }

    public Message process(Message input){
        return Message.builder()
                .id(input.id)
                .airplaneId(input.airplaneId)
                .latitude(input.getLatitude())
                .longitude(input.getLongitude())
                .airportLongitude(input.getAirportLongitude())
                .airportLatitude(input.airportLatitude)
                .status(input.status)
                .build();
    }

}
