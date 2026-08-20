package com.arish.Crud_Practice.response;

public class ErrorResponse {
    int status;
    String message;
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
