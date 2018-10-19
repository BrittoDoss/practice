package com.java.circle.practice.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity ( ex.getLocalizedMessage (), HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler(CarException.class)
    public final ResponseEntity handleCarException(CarException ex, WebRequest request) {
        return new ResponseEntity ( "Bad licence plate format!", HttpStatus.BAD_REQUEST );
    }

}
