package com.pjem.api.services.exceptions.users;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class InvalidLoginException extends ErrorResponseException {
    public InvalidLoginException(){
        super(401, "Login inválido.");
    }
}
