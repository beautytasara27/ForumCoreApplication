package com.binus.project.forumcoreapplication.service.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message, Exception cause) {
        super(message,cause);
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
