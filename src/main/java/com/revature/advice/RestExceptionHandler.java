package com.revature.advice;

import com.revature.exceptions.NotLoggedInException;
import com.revature.exceptions.ProfileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotLoggedInException.class)
    public ResponseEntity<Object> handleNotLoggedInException(HttpServletRequest request, NotLoggedInException notLoggedInException) {

        String errorMessage = "Must be logged in to perform this action";

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }
    @ExceptionHandler({ProfileNotFoundException.class})
    public ResponseEntity<Object> handleProfileNotFoundExceptio(HttpServletRequest request, ProfileNotFoundException notFoundException){
        String errorMessage = "The profile you are looking for could not be found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
