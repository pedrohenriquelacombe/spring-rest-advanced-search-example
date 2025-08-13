package com.example.advancedsearch.resource.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

public record CustomErrorResponse(
        int status,
        String error,
        String message,
        List<CustomFieldError> errors,
        OffsetDateTime timestamp,
        String path) {

    public static CustomErrorResponse from(HttpStatusCode statusCode, String message, List<CustomFieldError> errors, String path) {
        var httpStatus = toHttpStatus(statusCode);

        return new CustomErrorResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                message,
                errors,
                OffsetDateTime.now(ZoneOffset.UTC),
                path
        );
    }

    private static HttpStatus toHttpStatus(HttpStatusCode statusCode) {
        if (statusCode instanceof HttpStatus httpStatus) {
            return httpStatus;
        }

        return Optional.ofNullable(HttpStatus.resolve(statusCode.value()))
                .orElseThrow(() -> new IllegalArgumentException("Invalid HTTP status code: " + statusCode.value()));
    }

}
