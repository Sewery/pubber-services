package com.overmighties.pubs_routes_service.service;

import com.overmighties.pubs_routes_service.client_model.DistanceClientResponse;
import com.overmighties.pubs_routes_service.client_model.RoutesClientResponse;
import com.overmighties.pubs_routes_service.client_model.RoutesClientRequest;
import com.overmighties.pubs_routes_service.remote_model.request.LocationRemoteRequest;
import com.overmighties.pubs_routes_service.remote_model.response.RoutesRemoteResponse;
import com.overmighties.pubs_routes_service.remote_model.response.TimeDistanceRemoteResponse;
import com.overmighties.pubs_routes_service.util.DistanceUnit;
import com.overmighties.pubs_routes_service.util.MovementMode;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutesService {
    private final RoutesClient routesClient;
//    @Cacheable( cacheNames = "Routes", key ="#destinationLocations")
    public Mono<RoutesClientResponse> getRoutes(
            RoutesClientRequest request,
            List<RoutesClientRequest.Location> destinationLocations
    ) {
        return routesClient
                .getRoutes(
                        mapToRemoteUserLocation(request),
                        mapToRemoteLocationDestinationList(request),
                        request.getMode()
                )
                .map(this::mapToRemoteRoutesResponse);
    }
    private LocationRemoteRequest mapToRemoteUserLocation(RoutesClientRequest request) {
        return new LocationRemoteRequest(
                List.of(
                    request.getUserLocation().getLatitude(),
                    request.getUserLocation().getLongitude()
            )
        );
    }
    private List<LocationRemoteRequest> mapToRemoteLocationDestinationList(RoutesClientRequest request) {
        return request.getDestinationLocations()
                .stream()
                .map(location ->
                        new LocationRemoteRequest(
                                List.of(
                                        location.getLatitude(),
                                        location.getLongitude()
                                )
                        )
                )
                .toList();
    }
    private RoutesClientResponse mapToRemoteRoutesResponse(RoutesRemoteResponse remoteResponse) {
        return new RoutesClientResponse(
                MovementMode.fromString(remoteResponse.mode()),
                mapToDistanceClientResponseList(remoteResponse.sourcesToTargets()),
                DistanceUnit.fromString(remoteResponse.distanceUnits())

        );
    }
    private List<DistanceClientResponse> mapToDistanceClientResponseList(
            List<List<TimeDistanceRemoteResponse>> sourcesToTargetResponse
    ) {
        return sourcesToTargetResponse
                .getFirst().stream()
                .map(remoteResponse ->new DistanceClientResponse(
                        remoteResponse.targetIndex(),
                        remoteResponse.distance()
                ))
                .toList();
    }
}
