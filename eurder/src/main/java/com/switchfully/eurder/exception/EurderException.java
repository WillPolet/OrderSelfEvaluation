package com.switchfully.eurder.exception;

import org.springframework.http.HttpStatus;

public class EurderException extends RuntimeException {
    private HttpStatus statusCode;

    public EurderException(String message, HttpStatus statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode(){
        return statusCode;
    }
}
