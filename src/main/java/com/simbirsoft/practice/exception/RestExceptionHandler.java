package com.simbirsoft.practice.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<Object> handleEntityNonFoundEx(EntityNotFoundException entityNotFoundException) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
                entityNotFoundException.getEntityName() + " not found exception", entityNotFoundException);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
