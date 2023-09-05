package com.pjem.api.services.exceptions;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class InternarServerErrorException extends ErrorResponseException {
    public InternarServerErrorException(){
        super(500, "Erro de acesso ao servidor.");
    }
}
