package com.dna.dev.userservice.exceptions;

import com.dna.dev.userservice.api.v1.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UsernameTakenException.class)
    public ResponseEntity<ErrorMessage> exception(UsernameTakenException usernameTakenException){
        return new ResponseEntity<>(new ErrorMessage(usernameTakenException.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmailTakenException.class)
    public ResponseEntity<ErrorMessage> exception(EmailTakenException emailTakenException){
        return new ResponseEntity<>(new ErrorMessage(emailTakenException.getMessage(), LocalDateTime.now()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ScaryStoryException.class)
    public ResponseEntity<ErrorMessage> exception(ScaryStoryException scaryStoryException){
        return new ResponseEntity<>(new ErrorMessage(scaryStoryException.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> exception(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(new ErrorMessage(userNotFoundException.getMessage(), LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
