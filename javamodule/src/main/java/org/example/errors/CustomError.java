package org.example.errors;

public class CustomError extends RuntimeException {
    public CustomError(String message) {
        super(message);
    }
}
