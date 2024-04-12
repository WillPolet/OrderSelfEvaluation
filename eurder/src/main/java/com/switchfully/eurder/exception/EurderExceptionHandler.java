package com.switchfully.eurder.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.StringJoiner;

@ControllerAdvice
public class EurderExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(EurderExceptionHandler.class);

    @ExceptionHandler(EurderException.class)
    protected ResponseEntity<ExceptionDto> exceptionFound(EurderException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(ex.getStatusCode()).body(new ExceptionDto(ex.getMessage()));
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        StringJoiner sj = new StringJoiner(" ");
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            sj.add(((FieldError) error).getField() + ": " + error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(new ExceptionDto(sj.toString()));
    }
}
