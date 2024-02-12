package com.realworld.exception;

public class CategoryAlreadyCreatedException extends RuntimeException {
    public CategoryAlreadyCreatedException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
