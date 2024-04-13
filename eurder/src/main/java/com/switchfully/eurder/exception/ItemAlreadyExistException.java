package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class ItemAlreadyExistException extends EurderException{
    public ItemAlreadyExistException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
