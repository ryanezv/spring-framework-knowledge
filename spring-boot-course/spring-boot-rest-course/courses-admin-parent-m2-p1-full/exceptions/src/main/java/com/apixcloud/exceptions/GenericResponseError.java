package com.apixcloud.exceptions;

public class GenericResponseError {
    
    private String code;    
    private String message;
    private String developerMessage;    
    
    public GenericResponseError(String code, String message, String developerMessage) {
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDeveloperMessage() {
        return developerMessage;
    }
    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
