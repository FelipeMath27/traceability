package com.pragma.traceability.infrastructure.exceptions;

public class MicroserviceConnectionException extends RuntimeException {
    public MicroserviceConnectionException(String message) {
        super(message);
    }
    public MicroserviceConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}