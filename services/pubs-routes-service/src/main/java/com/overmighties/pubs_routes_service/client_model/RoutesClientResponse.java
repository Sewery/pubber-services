package com.overmighties.pubs_routes_service.client_model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.overmighties.pubs_routes_service.util.DistanceUnit;
import com.overmighties.pubs_routes_service.util.MovementMode;

import java.util.List;

public record RoutesClientResponse(
        MovementMode mode,
        @JsonProperty("distances_to_destinations") List<DistanceClientResponse> distancesToDestinations,
        @JsonProperty("distance_unit") DistanceUnit distanceUnit
) {
}
