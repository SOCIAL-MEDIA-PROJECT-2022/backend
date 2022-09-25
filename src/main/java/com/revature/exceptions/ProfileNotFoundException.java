package com.revature.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    public ProfileNotFoundException(){
        super("The profile you are looking for does not exist");
    }
}
