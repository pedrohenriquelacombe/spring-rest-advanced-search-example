package com.example.advancedsearch.resource.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return this.handleResponse(ex, headers, status, request, "Malformed JSON request", Collections.emptyList());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var errors = ex.getFieldErrors()
                .stream()
                .map(CustomFieldError::fromFieldError)
                .toList();

        return this.handleResponse(ex, headers, status, request, "Validation failed", errors);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var message = String.format("No handler found for %s %s", ex.getHttpMethod(), ex.getRequestURL());

        return this.handleResponse(ex, headers, status, request, message, Collections.emptyList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleAllExceptions(Exception ex, HttpServletRequest request) {
        var httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        var body = CustomErrorResponse.from(httpStatus, "Unexpected Error", Collections.emptyList(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(body);
    }

    private ResponseEntity<Object> handleResponse(Exception ex, HttpHeaders headers, HttpStatusCode status, WebRequest request, String message, List<CustomFieldError> errors) {
        var path = ((ServletWebRequest) request).getRequest().getRequestURI();
        var body = CustomErrorResponse.from(status, message, errors, path);

        return this.handleExceptionInternal(ex, body, headers, status, request);
    }

}
