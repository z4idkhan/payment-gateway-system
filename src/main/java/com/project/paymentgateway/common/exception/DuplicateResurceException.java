package com.project.paymentgateway.common.exception;

import lombok.Getter;

@Getter
public class DuplicateResurceException extends RuntimeException {

    private final String errorCode;

    public DuplicateResurceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
