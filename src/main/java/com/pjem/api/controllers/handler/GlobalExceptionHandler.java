package com.pjem.api.controllers.handler;
import com.pjem.api.services.exceptions.users.InvalidLoginException;
import com.pjem.api.services.exceptions.users.UserNotFoundException;
import com.pjem.api.services.exceptions.users.UserRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<PersonalError> handleUserNotFoundException(UserNotFoundException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(UserRegisteredException.class)
    public ResponseEntity<PersonalError> UserRegisteredException(UserRegisteredException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }


    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<PersonalError> UserRegisteredException(InvalidLoginException ex) {
        PersonalError erro = new PersonalError(ex.getCode(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
    }

}
