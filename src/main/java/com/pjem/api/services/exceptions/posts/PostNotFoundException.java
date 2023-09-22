package com.pjem.api.services.exceptions.posts;

import com.pjem.api.controllers.handler.ErrorResponseException;

public class PostNotFoundException extends ErrorResponseException {
    public PostNotFoundException(){
        super(404, "Post não localizado.");
    }
}
