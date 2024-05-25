package com.apixcloud.exceptions;

public class MyBadRequestException extends RuntimeException {
    
    private GenericResponseError response;

    public MyBadRequestException(){
        super();
    }
    
    public MyBadRequestException(final String message){
        super(message);
    }

    public MyBadRequestException(final String message, Throwable throwable){
        super(message, throwable);
    }

    public MyBadRequestException(final String message, Throwable throwable, GenericResponseError response){
        super(message, throwable);
        this.response = response;
    }
}
