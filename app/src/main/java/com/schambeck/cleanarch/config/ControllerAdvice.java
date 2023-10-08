package com.schambeck.cleanarch.config;

import com.schambeck.cleanarch.usecase.exception.NotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = NOT_FOUND, reason = "Entity not found")
    void handleNotFound() {
    }
}
