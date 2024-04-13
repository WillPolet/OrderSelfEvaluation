package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class AccessForbiddenException extends EurderException{
    public AccessForbiddenException (String message){
        super(message, HttpStatus.FORBIDDEN);
    }
}
