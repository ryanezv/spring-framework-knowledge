package com.apixcloud.commons.web.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GenericResponseError {
    
    private int status;
    private String message;
    private String developerMessage;

}
