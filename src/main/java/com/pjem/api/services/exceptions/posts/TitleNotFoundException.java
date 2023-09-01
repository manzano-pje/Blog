package com.pjem.api.services.exceptions.posts;

import com.pjem.api.services.exceptions.ErrorResponseException;

public class TitleNotFoundException extends ErrorResponseException {
    public TitleNotFoundException(){
        super(404, "Título não locaizado.");
    }
}
