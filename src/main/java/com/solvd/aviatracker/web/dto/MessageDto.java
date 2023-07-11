package com.solvd.aviatracker.web.dto;

import com.solvd.aviatracker.domain.Message;
import lombok.Data;

@Data
public class MessageDto {

    private String airplaneId;
    private Double latitude;
    private Double longitude;
    private Message.Status status;

}
