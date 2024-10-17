package com.overmighties.pubs_routes_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.overmighties.pubs_routes_service.client_model.RoutesClientRequest;
import com.overmighties.pubs_routes_service.controller.RoutesController;
import com.overmighties.pubs_routes_service.remote_model.request.LocationRemoteRequest;
import com.overmighties.pubs_routes_service.util.MovementMode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import reactor.test.StepVerifier;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoutesControllerIntegrationTest
{
    private static final Logger log = LoggerFactory.getLogger(RoutesControllerIntegrationTest.class);
    @Autowired
    private RoutesController routesController;
    @Autowired
    private ObjectMapper objectMapper;
    private static RoutesClientRequest routesClientRequest;
    @BeforeAll
    static void beforeAll() {
        routesClientRequest = new RoutesClientRequest(
                MovementMode.WALK,
                new RoutesClientRequest.Location(50.0597735,21.9677626),
                List.of(
                        new RoutesClientRequest.Location(50.0371114,22.0056211),
                        new RoutesClientRequest.Location(50.0380261,22.002643)
                )
        );
    }
    @Test
    void testGetRoutes() throws JsonProcessingException {
        log.info(objectMapper.writeValueAsString(routesClientRequest));
        StepVerifier
                .create(routesController.getRoutes(routesClientRequest))
                .consumeNextWith(response->log.info(response.toString()))
                .expectComplete()
                .verify();
    }
}
