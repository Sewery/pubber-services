package com.overmighties.pubsdataservice.controller;

import com.overmighties.pubsdataservice.controller.clientdto.PubClientDto;
import com.overmighties.pubsdataservice.service.PubService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/pubs")
public class PubController {
    private final PubService pubService;

    @GetMapping("/*")
    public ResponseEntity<List<PubClientDto>> getPubs()
    {
        return ResponseEntity.ok(pubService.getPubDtoListOptimized());
    }
    @GetMapping("/{city-name}")
    public  ResponseEntity<List<PubClientDto>> getPubsByCity( @PathVariable("city-name")  String cityName)
    {
        return ResponseEntity.ok(pubService.getPubDtoListOptimized(cityName));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PubClientDto> getPubById(@PathVariable("id")  @Positive Long id)
    {
        return ResponseEntity.ok(pubService.getPubById(id));
    }


}
