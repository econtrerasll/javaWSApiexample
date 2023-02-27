package com.claro.resttest.ErrorHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SOAPAdvice {

    @ResponseBody
    @ExceptionHandler(SoapException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String badUrlSoapHandler(SoapException ex) {
        return ex.getMessage();
    }

}
