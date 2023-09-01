package com.pjem.api.services.exceptions;

import org.springframework.web.client.HttpServerErrorException;

public class InternarServerErrorException extends ErrorResponseException{
    public InternarServerErrorException(){
        super(500, "Erro de acesso ao servidor.");
    }
}
