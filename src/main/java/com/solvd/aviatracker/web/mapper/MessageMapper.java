package com.solvd.aviatracker.web.mapper;

import com.solvd.aviatracker.domain.Message;
import com.solvd.aviatracker.web.dto.MessageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageDto toDto(Message message);

    Message toEntity(MessageDto messageDto);

}
