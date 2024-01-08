package com.realworld.exception;

public class ClientBooksNotFoundException extends RuntimeException{
    private final String exceptionMessage;
    private final String developerMessage;
    private final int page;
    private final int size;

    public ClientBooksNotFoundException(String exceptionMessage, String developerMessage, int page, int size) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
        this.developerMessage = developerMessage;
        this.page = page;
        this.size = size;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
    public String getDeveloperMessage() {
        return developerMessage;
    }
    public int getPage() {
        return page;
    }
    public int getSize() {
        return size;
    }
}