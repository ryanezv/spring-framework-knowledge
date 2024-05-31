package com.apixcloud.courses.controllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.apixcloud.commons.web.exceptions.GenericResponseError;
import com.apixcloud.commons.web.exceptions.MyBadRequestException;
import com.apixcloud.commons.web.exceptions.MyConflictException;
import com.apixcloud.commons.web.exceptions.MyResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionsController extends ResponseEntityExceptionHandler{
    
    /*  HTTP 400 */

    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected final ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.info("Bad Request: {}", ex.getMessage());
        log.debug("Bad Request: {}", ex);
        //final String bodyOfResponse = "<handleHttpMessageNotReadable> Mensaje HTTP 400 para nuestro cliente final";
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    
    @Override
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected final ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        log.info("Bad Request: {}", ex.getMessage());
        log.debug("Bad Request: {}", ex);
        //final String bodyOfResponse = "<handleMethodArgumentNotValid> Mensaje HTTP 400 para nuestro cliente final";
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
    }

    
    @ExceptionHandler({ ConstraintViolationException.class, MyBadRequestException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleBadRequest(final RuntimeException ex, final WebRequest request) {
        log.info("Bad Request: {}", ex.getMessage());
        log.debug("Bad Request: {}", ex);
        //final String bodyOfResponse = "<handleNotFound> Mensaje HTTP 400 para nuestro cliente final";        
        return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    // 401
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ResponseEntity<Object> handleUnauthorized(final AuthenticationException ex, final WebRequest request) {
        logger.error("401 Status Code", ex);

        final GenericResponseError apiError = message(HttpStatus.UNAUTHORIZED, ex);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    // 403

    @ExceptionHandler({ AccessDeniedException.class })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    protected ResponseEntity<Object> handleEverything(final AccessDeniedException ex, final WebRequest request) {
        logger.error("403 Status Code", ex);

        final GenericResponseError apiError = message(HttpStatus.FORBIDDEN, ex);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    // 404

    @ExceptionHandler({ MyResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        log.info("Not Found: {}", ex.getMessage());
        log.debug("Not Found: {}", ex);
        return handleExceptionInternal(ex, message(HttpStatus.NOT_FOUND, ex), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
   
    // 409

    @ExceptionHandler({ MyConflictException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
        log.info("Conflict Request: {}", ex.getMessage());
        log.debug("Conflict Request: {}", ex);
        return handleExceptionInternal(ex, message(HttpStatus.CONFLICT, ex), new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    // 500

    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)    
    protected ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
        logger.error("500 Status Code", ex);
        final String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private final GenericResponseError message(final HttpStatus httpStatus, final Exception ex) {
        final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
        final String devMessage = ExceptionUtils.getRootCauseMessage(ex);

        return new GenericResponseError(httpStatus.value(), message, devMessage);
    }
}
