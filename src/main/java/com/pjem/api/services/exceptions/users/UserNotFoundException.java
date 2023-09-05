package com.pjem.api.services.exceptions.users;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class UserNotFoundException extends ErrorResponseException {

    public UserNotFoundException(){
        super(404, "Usuário não existe.");
    }
}

