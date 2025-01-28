package com.overmighties.pubs_routes_service.controller;

import com.overmighties.pubs_routes_service.client_model.RoutesClientRequest;
import com.overmighties.pubs_routes_service.client_model.RoutesClientResponse;
import com.overmighties.pubs_routes_service.service.RoutesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RoutesController {
    private final RoutesService routesService;
    @PostMapping("/")
    public Mono<ResponseEntity<RoutesClientResponse>> getRoutes(@Valid @RequestBody RoutesClientRequest request){

        Mono<RoutesClientResponse> response = routesService.getRoutes(request,request.getDestinationLocations());
        return response
                .map(data ->{
                    return ResponseEntity.ok().body(data);
                });
    }
}
