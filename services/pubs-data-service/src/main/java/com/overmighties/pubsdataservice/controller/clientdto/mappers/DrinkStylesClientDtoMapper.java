package com.overmighties.pubsdataservice.controller.clientdto.mappers;

import com.overmighties.pubsdataservice.controller.clientdto.DrinkStylesClientDto;
import com.overmighties.pubsdataservice.model.DrinkStyles;

import java.util.List;

public class DrinkStylesClientDtoMapper {
    private DrinkStylesClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<DrinkStylesClientDto> mapToDtoList(List<DrinkStyles> drinkStyles)
    {
        return drinkStyles==null?null:drinkStyles.stream()
                .map(DrinkStylesClientDtoMapper::mapToDto)
                .toList();
    }
    public static DrinkStylesClientDto mapToDto(DrinkStyles drinkStyles)
    {
        return new DrinkStylesClientDto(drinkStyles.getStyleName());
    }
}
