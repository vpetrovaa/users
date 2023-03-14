package com.solvd.users.domain.exception;

public class ResourceDoesNotExistException extends RuntimeException{

    public ResourceDoesNotExistException(String message) {
        super(message);
    }

}
