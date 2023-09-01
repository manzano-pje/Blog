package com.pjem.api.services.exceptions.users;

import com.pjem.api.services.exceptions.ErrorResponseException;

public class UserNotFoundExceptoin extends ErrorResponseException {

    public UserNotFoundExceptoin(){
        super(404, "Usuário não existe.");
    }
}
