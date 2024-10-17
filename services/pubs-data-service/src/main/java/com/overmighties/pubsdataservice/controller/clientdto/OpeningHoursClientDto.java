package com.overmighties.pubsdataservice.controller.clientdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OpeningHoursClientDto {
    private String weekday;
    @NotBlank
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeOpen;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timeClose;
}
