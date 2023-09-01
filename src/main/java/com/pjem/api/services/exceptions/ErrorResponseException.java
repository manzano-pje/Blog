package com.pjem.api.services.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseException extends RuntimeException {
    private Integer code;
    private String message;

    public ErrorResponseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Map<String, Object> paraJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("erro: ", code);
        json.put("mensagem: ", message);
        return json;
    }

}

