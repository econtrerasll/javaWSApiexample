package com.claro.resttest.ErrorHandlers;

public class RouterNotFoundException extends RuntimeException{
    public RouterNotFoundException(Long id) {
        super("Router no encontrado con ID: " + id);
    }
}
