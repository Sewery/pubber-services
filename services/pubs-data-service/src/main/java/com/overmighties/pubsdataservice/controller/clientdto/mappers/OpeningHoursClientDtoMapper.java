package com.overmighties.pubsdataservice.controller.clientdto.mappers;

import com.overmighties.pubsdataservice.controller.clientdto.OpeningHoursClientDto;
import com.overmighties.pubsdataservice.model.OpeningHours;

import java.util.List;

public class OpeningHoursClientDtoMapper {
    private OpeningHoursClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<OpeningHoursClientDto> mapToDtoList(List<OpeningHours> openingHours)
    {
        return null==openingHours?null:openingHours.stream()
                .map(OpeningHoursClientDtoMapper::mapToDto)
                .toList();
    }
    public static OpeningHoursClientDto mapToDto(OpeningHours openingHours)
    {
        return OpeningHoursClientDto.builder()
                .weekday(openingHours.getWeekday())
                .timeOpen(openingHours.getTimeOpen())
                .timeClose(openingHours.getTimeClose())
                .build();
    }
}
