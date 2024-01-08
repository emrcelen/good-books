package com.realworld.exception;

public class ClientInvalidParameterException extends RuntimeException{
    private final String exceptionMessage;
    private final String developerMessage;
    private final String parameter;

    public ClientInvalidParameterException(String exceptionMessage, String developerMessage, String parameter) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
        this.developerMessage = developerMessage;
        this.parameter = parameter;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
    public String getDeveloperMessage() {
        return developerMessage;
    }
    public String getPageSize() {
        return parameter;
    }
}