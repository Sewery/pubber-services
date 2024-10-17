package com.overmighties.pubsdataservice.controller.clientdto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DrinkClientDto {
    private String name;
    private String type;
    private String description;
    private List<DrinkStylesClientDto> drinkStyles;
}
