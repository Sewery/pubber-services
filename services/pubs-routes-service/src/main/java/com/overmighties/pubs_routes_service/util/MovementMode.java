package com.overmighties.pubs_routes_service.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MovementMode {
    DRIVE("drive"),
    WALK("walk"),
    BICYCLE("bicycle");
    private final String modeLowerCase;
    public static MovementMode fromString(String value) {
        for (MovementMode mode : MovementMode.values()) {
            if (mode.name().equalsIgnoreCase(value)) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Invalid movement mode: " + value);
    }
}
