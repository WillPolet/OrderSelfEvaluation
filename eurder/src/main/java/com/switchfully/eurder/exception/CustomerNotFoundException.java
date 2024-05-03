package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends EurderException{
    public CustomerNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
