package com.overmighties.pubs_routes_service.remote_model.request;

import java.util.List;

public record RoutesRemoteRequest(
       String mode,
       List<LocationRemoteRequest> sources,
       List<LocationRemoteRequest> targets

) {
}
