package com.pjem.api.services.exceptions.posts;

import com.pjem.api.services.exceptions.ErrorResponseException;

public class PostNotFounfException extends ErrorResponseException {
    public PostNotFounfException(){
        super(404, "Post ão localizado.");
    }
}
