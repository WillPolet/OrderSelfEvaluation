package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends EurderException{
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}
