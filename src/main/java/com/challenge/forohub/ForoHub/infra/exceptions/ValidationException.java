package com.challenge.forohub.ForoHub.infra.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String mensaje){
        super(mensaje);
    }
}
