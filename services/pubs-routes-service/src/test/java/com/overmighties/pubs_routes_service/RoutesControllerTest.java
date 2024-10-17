package com.overmighties.pubs_routes_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.overmighties.pubs_routes_service.client_model.RoutesClientRequest;
import com.overmighties.pubs_routes_service.util.MovementMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class RoutesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateRoute() throws Exception {
        // Create a sample request
        RoutesClientRequest request = new RoutesClientRequest();
        request.setMode(MovementMode.WALK);
        request.setUserLocation(new RoutesClientRequest.Location(50.0597735,21.9677626));
        request.setDestinationLocations(List.of(
                new RoutesClientRequest.Location(50.0371114,22.0056211),
                new RoutesClientRequest.Location(50.0380261,22.002643)
        ));

        // Convert the request object to JSON
        String requestJson = objectMapper.writeValueAsString(request);

        // Perform POST request with JSON body
        mockMvc.perform(post("/api/routes/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
