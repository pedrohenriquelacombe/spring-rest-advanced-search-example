package com.example.advancedsearch.resource.exceptionHandler;

import org.springframework.validation.FieldError;

public record CustomFieldError(String field, String message) {
    public static CustomFieldError fromFieldError(FieldError fieldError) {
        return new CustomFieldError(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
