package com.overmighties.pubs_routes_service.util;

public enum DistanceUnit {
    KILOMETERS,
    METERS,
    MILES;
    public static DistanceUnit fromString(String value) {
        for (DistanceUnit unit : DistanceUnit.values()) {
            if (unit.name().equalsIgnoreCase(value)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("Invalid distance unit: " + value);
    }
}
