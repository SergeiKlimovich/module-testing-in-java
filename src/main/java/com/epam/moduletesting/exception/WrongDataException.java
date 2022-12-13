package com.epam.moduletesting.exception;

public class WrongDataException extends RuntimeException {

    public WrongDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataException(String message) {
        super(message);
    }
}
