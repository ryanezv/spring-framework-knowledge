package com.apixcloud.courses.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.apixcloud.commons.persistence.exception.MyEntityNotFoundException;
import com.apixcloud.commons.web.exception.MyResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionsController extends ResponseEntityExceptionHandler{
    
    private Logger log = LoggerFactory.getLogger(getClass());    

    @ExceptionHandler({ MyEntityNotFoundException.class, MyResourceNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        final String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
