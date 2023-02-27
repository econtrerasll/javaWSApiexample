package com.claro.resttest.ErrorHandlers;


public class CelularNotFoundException extends RuntimeException{
    public CelularNotFoundException(Long id) {
        super("Celular no encontrado con ID: " + id);
    }
}
