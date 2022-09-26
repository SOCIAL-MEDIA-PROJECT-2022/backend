package com.revature.advice;

import com.revature.exceptions.NotLoggedInException;
import com.revature.exceptions.ProfileNotFoundException;
import com.revature.exceptions.UserDoesNotExistException;
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
    public ResponseEntity<Object> handleProfileNotFoundException(HttpServletRequest request, ProfileNotFoundException notFoundException) {
        String errorMessage = "The profile you are looking for could not be found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler({UserDoesNotExistException.class})
    public ResponseEntity<Object> handleUserDoesNotExistException(HttpServletRequest request, UserDoesNotExistException doesNotExistException) {
        String errorMessage = "User does not exist or you are not authorized to perform this action";
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
    }
}
