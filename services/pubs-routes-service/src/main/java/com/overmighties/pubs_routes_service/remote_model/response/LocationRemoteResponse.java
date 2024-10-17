package com.overmighties.pubs_routes_service.remote_model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LocationRemoteResponse(
        @JsonProperty("original_location") List<Double> originalLocation,
        @JsonProperty("location") List<Double> location
) {
}
