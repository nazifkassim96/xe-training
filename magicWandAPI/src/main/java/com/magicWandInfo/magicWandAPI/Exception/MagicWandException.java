package com.magicWandInfo.magicWandAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MagicWandException extends RuntimeException{

    public static final String INVALID_ID = "Invalid ID!";

    public MagicWandException(String message){ super(message); }

    public MagicWandException(String message, Throwable exceptionMessage){
        super(message);
    }
}
