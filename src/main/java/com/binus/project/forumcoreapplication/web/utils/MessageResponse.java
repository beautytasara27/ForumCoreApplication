package com.binus.project.forumcoreapplication.web.utils;

public class MessageResponse {
    private final String message;

    private MessageResponse(String message) {
        this.message = message;
    }

    public static MessageResponse createMessageResponse(String message) {
        return new MessageResponse(message);
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
