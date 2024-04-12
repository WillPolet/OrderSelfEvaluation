package com.switchfully.eurder.exception;

public class ExceptionDto {
    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
