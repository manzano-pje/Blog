package com.pjem.api.services.exceptions.users;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class UserRegisteredException extends ErrorResponseException {
    public UserRegisteredException(){
        super(409, "Usário já cadastrado");
    }
}
