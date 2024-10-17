package com.overmighties.pubsdataservice.service;

import com.overmighties.pubsdataservice.controller.clientdto.DrinkClientDto;
import com.overmighties.pubsdataservice.controller.clientdto.mappers.DrinkClientDtoMapper;
import com.overmighties.pubsdataservice.exception.EntityIdNotFoundException;
import com.overmighties.pubsdataservice.model.Drink;
import com.overmighties.pubsdataservice.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public List<DrinkClientDto> getDrinks()
    {
        return DrinkClientDtoMapper
                .mapToDtoList(drinkRepository
                        .findAll()
                        .stream()
                        .toList()
                );
    }
    public DrinkClientDto getDrink(Long id)
    {
        return DrinkClientDtoMapper
                .mapToDto(drinkRepository
                        .findById(id)
                        .orElseThrow(()->new EntityIdNotFoundException(Drink.class,id))
                );
    }

}
