package com.pjem.api.services.exceptions.posts;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class TagNotFoundException extends ErrorResponseException {
    public TagNotFoundException(){
        super(404, "Tag não localizada.");
    }
}
