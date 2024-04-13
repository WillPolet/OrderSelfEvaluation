package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class PasswordNotMatchException extends EurderException{
    public PasswordNotMatchException (String message){
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
