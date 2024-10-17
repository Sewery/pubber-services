package com.overmighties.pubs_routes_service.client_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.overmighties.pubs_routes_service.util.MovementMode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutesClientRequest {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Valid
    public static class Location{
        @NotNull
        @DecimalMin(value="-180.0")
        @DecimalMax(value="180.0")
        private Double latitude;
        @NotNull
        @DecimalMin(value="-90.0")
        @DecimalMax(value="90.0")
        private Double longitude;
    }
    @NotNull
    private MovementMode mode;
    @NotNull
    @JsonProperty("user_location")
    @Valid
    private Location userLocation;
    @NotNull
    @JsonProperty("destination_locations")
    @Valid
    private List<Location> destinationLocations;
}
