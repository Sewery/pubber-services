package com.overmighties.pubs_routes_service.remote_model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record RoutesRemoteResponse(
        List<LocationRemoteResponse> sources,
        List<LocationRemoteResponse> targets,
        @JsonProperty("sources_to_targets") List<List<TimeDistanceRemoteResponse>> sourcesToTargets,
        String units,
        @JsonProperty("distance_units") String distanceUnits,
        String mode
){
}
