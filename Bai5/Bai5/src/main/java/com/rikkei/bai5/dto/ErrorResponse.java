package com.rikkei.bai5.dto;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String errorType;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(String errorType, String message) {
        this.errorType = errorType;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters
    public String getErrorType() { return errorType; }
    public String getMessage() { return message; }
    public LocalDateTime getTimestamp() { return timestamp; }
}