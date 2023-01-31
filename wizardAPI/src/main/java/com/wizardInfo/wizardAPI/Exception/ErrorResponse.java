package com.wizardInfo.wizardAPI.Exception;

import org.aspectj.bridge.Message;

public class ErrorResponse extends RuntimeException{
    public ErrorResponse() {
        super();
    }

    public ErrorResponse(String message, Throwable cause){
        super(message, cause);
    }

    public ErrorResponse(String message){
        super(message);
    }
    public ErrorResponse(Throwable cause){
        super(cause);
    }
}
