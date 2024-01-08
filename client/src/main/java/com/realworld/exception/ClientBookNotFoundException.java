package com.realworld.exception;

public class ClientBookNotFoundException extends RuntimeException {
    private final String exceptionMessage;
    private final String developerMessage;

    public ClientBookNotFoundException(String exceptionMessage, String developerMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
        this.developerMessage = developerMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
    public String getDeveloperMessage() {
        return developerMessage;
    }

}