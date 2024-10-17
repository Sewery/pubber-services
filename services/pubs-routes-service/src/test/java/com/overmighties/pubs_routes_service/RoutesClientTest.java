package com.overmighties.pubs_routes_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.overmighties.pubs_routes_service.remote_model.request.RoutesRemoteRequest;
import com.overmighties.pubs_routes_service.remote_model.request.LocationRemoteRequest;
import com.overmighties.pubs_routes_service.service.RoutesClient;
import com.overmighties.pubs_routes_service.util.MovementMode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoutesClientTest {
    private static final Logger log = LoggerFactory.getLogger(RoutesClientTest.class);
    @Autowired
    private RoutesClient routesClient;
    private static List<LocationRemoteRequest> sources;
    private static List<LocationRemoteRequest> targets;
    private static MovementMode movementMode;
    @Autowired
    private ObjectMapper objectMapper;
    @BeforeAll
    static void beforeAll() {
        sources =List.of(new LocationRemoteRequest(List.of(50.0597735,21.9677626)));
        targets =List.of(
                new LocationRemoteRequest(List.of(50.0371114,22.0056211)),
                new LocationRemoteRequest(List.of(50.0380261,22.002643))
        );
        movementMode=MovementMode.WALK;

    }
    @Test
    void testMappingSerialization() throws JsonProcessingException {
        RoutesRemoteRequest routesRequest = new RoutesRemoteRequest(MovementMode.WALK.getModeLowerCase(), sources,targets);
        String json = objectMapper.writer()
                .writeValueAsString(routesRequest);
        log.info(json);
    }
    @Test
    void testGetRoutes() {
        StepVerifier
                .create(routesClient.getRoutes(sources.getFirst(),targets,movementMode))
                .consumeNextWith(response->log.info(response.toString()))
                .expectComplete()
                .verify();
    }
}