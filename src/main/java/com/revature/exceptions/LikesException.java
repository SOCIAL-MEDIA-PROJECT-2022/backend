package com.revature.exceptions;

public class LikesException extends RuntimeException {


    public LikesException() {
        super("You already liked this post.");
    }

    public LikesException(String message) {
        super(message);

    }
}
