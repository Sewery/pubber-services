package com.overmighties.pubs_routes_service.service;


import com.overmighties.pubs_routes_service.remote_model.request.RoutesRemoteRequest;
import com.overmighties.pubs_routes_service.remote_model.request.LocationRemoteRequest;
import com.overmighties.pubs_routes_service.remote_model.response.RoutesRemoteResponse;
import com.overmighties.pubs_routes_service.util.MovementMode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class RoutesClient {
    private final WebClient webClient;
    @Value("${geoapify.api.key}")
    private String GEOAPIFY_API_KEY;
    public RoutesClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.geoapify.com/v1/routematrix")
                .build();
    }
    public Mono<RoutesRemoteResponse> getRoutes(
            LocationRemoteRequest userLocationRequest,
            List<LocationRemoteRequest> destinations,
            MovementMode mode
    ){
        RoutesRemoteRequest routesRequest = new RoutesRemoteRequest(
                mode.getModeLowerCase(),
                List.of(userLocationRequest),
                destinations
        );
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("apiKey", GEOAPIFY_API_KEY)
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(routesRequest)
                .retrieve()
                .bodyToMono(RoutesRemoteResponse.class);
    }
}


