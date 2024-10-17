package com.overmighties.pubs_routes_service.remote_model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TimeDistanceRemoteResponse(
        Long distance,
        Long time,
        @JsonProperty("source_index") Integer sourceIndex,
        @JsonProperty("target_index") Integer targetIndex
) {
}
