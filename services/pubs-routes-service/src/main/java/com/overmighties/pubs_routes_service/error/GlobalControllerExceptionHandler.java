package com.overmighties.pubs_routes_service.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class GlobalControllerExceptionHandler {

    private final ObjectMapper objectMapper;

/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<ApiError>> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            ServerWebExchange exchange
    ){
        return Mono.fromCallable(() -> {
            Map<String, String> errors = new HashMap<>();
            exception.getBindingResult()
                    .getAllErrors()
                    .forEach(err -> {
                        String fieldName = ((FieldError) err).getField();
                        String message = err.getDefaultMessage();
                        errors.put(fieldName, message);
                    });
            ApiError apiError = new ApiError(
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    "Client Request Validation Error",
                    exchange.getRequest().getPath().toString(),
                    objectMapper.writeValueAsString(errors)
            );
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUE+ST);
        });
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Mono<ResponseEntity<ApiError>> handlePathVariableNotValid(
            ConstraintViolationException exception,
            ServerWebExchange exchange
    ){
        return Mono.fromCallable(() -> {
            Map<String, String> errors = new HashMap<>();
            ApiError apiError = new ApiError(
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    "Client Path Variable Validation Error",
                    exchange.getRequest().getPath().toString(),
                    errors.put(exception.getMessage()
            );
            return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
        });
    }
*/

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiError handleConstraintViolationException(WebExchangeBindException ex) {
        Map<String, List<String>> body = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            body.putIfAbsent(fieldError.getField(), new ArrayList<>());
            var errors = body.get(fieldError.getField());
            errors.add(fieldError.getDefaultMessage());
        }
        return new ApiError(
                LocalDateTime.now(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Invalid Request Error",
                ex.getBindingResult().getNestedPath(),
                body
        );
    }

}
