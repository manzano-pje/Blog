package com.pjem.api.controllers.handler;

public class PersonalError {
    private Integer code;
    private String message;

    public PersonalError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
