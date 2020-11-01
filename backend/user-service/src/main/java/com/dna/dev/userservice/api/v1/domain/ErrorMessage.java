package com.dna.dev.userservice.api.v1.domain;

import java.time.LocalDateTime;

public class ErrorMessage {
    private String message;
    private LocalDateTime timestamp;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
