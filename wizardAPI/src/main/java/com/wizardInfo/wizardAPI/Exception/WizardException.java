package com.wizardInfo.wizardAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WizardException extends RuntimeException {

    public static final  String INVALID_ID = "Invalid Wizard ID!";

    public WizardException(){
        super();
    }
    public WizardException(String message) {
        super(message);
    }

}
