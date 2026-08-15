package com.project.paymentgateway.common.exception;

import lombok.Getter;

@Getter
public class ResourseNotFoundException extends RuntimeException {

    private final String resourceName;
    private final String identifier;

    public ResourseNotFoundException(String resourceName, String identifier) {
        super(resourceName+"Not Found: "+identifier);
        this.resourceName = resourceName;
        this.identifier = identifier;
    }
}
