package com.pjem.api.controllers.handler;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponseException extends RuntimeException {
    private Integer code;
    private String message;

    public ErrorResponseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {return message;}

    public Map<String, Object> paraJson() {
        Map<String, Object> json = new HashMap<>();
        json.put("erro", code); // Remova os dois pontos extras (":") aqui
        json.put("mensagem", message); // Remova os dois pontos extras (":") aqui
        return json;
    }
}



