package com.goldmoon.common.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    HttpStatus status;
    ErrorMessage errorMessage;
    private String detailedMessage;

    public ApiException(HttpStatus status, ErrorMessage errorMessage, String... detailedMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
        if (detailedMessage == null) {
            this.detailedMessage = errorMessage.getDesc();
        } else {
            this.detailedMessage = String.format(errorMessage.getDesc(), (Object[]) detailedMessage);
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    @Override
    public String getMessage() {
        return detailedMessage;
    }
}