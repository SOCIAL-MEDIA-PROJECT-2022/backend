package com.revature.exceptions;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException() {
        super("The user does not exist or you are not logged in");
    }
}
