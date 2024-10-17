package com.overmighties.pubs_routes_service.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record ApiError(
        @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss.SS") LocalDateTime timestamp,
        Integer status,
        @JsonProperty("error_type")String errorType,
        String path,
        Map<String, List<String>> errors
) {
}
