package com.overmighties.pubsdataservice.controller;

import com.overmighties.pubsdataservice.controller.clientdto.DrinkClientDto;
import com.overmighties.pubsdataservice.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drinks")
@RequiredArgsConstructor
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping("/*")
    public ResponseEntity<List<DrinkClientDto>> getDrinks() {
        return ResponseEntity.ok(drinkService.getDrinks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DrinkClientDto> getDrinkById(@PathVariable("id") Long id)
    {
        return ResponseEntity.ok(drinkService.getDrink(id));
    }

}
