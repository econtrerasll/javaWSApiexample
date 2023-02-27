package com.claro.resttest.ErrorHandlers;

public class SoapException extends RuntimeException {
    public SoapException() {
        super("Bad URL for SOAP SERVER");
    }
}
