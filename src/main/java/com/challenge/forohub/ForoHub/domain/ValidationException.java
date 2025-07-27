package com.challenge.forohub.ForoHub.domain;

public class ValidationException extends RuntimeException {

    public ValidationException(String mensaje){
        super(mensaje);
    }
}
