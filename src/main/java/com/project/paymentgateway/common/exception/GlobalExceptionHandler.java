package com.project.paymentgateway.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResurceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateResources(DuplicateResurceException excep){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ErrorResponse.of(excep.getErrorCode(),excep.getMessage()));
    }
}
