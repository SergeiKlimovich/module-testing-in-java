package com.epam.moduletesting.exception;

public class WrongPathException extends RuntimeException {
    public WrongPathException(String message, Throwable cause) {
        super(message, cause);
    }
}
