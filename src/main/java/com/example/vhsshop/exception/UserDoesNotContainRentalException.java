package com.example.vhsshop.exception;

public class UserDoesNotContainRentalException extends RuntimeException{

    public UserDoesNotContainRentalException(String message) {
        super(message);
    }

    public UserDoesNotContainRentalException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesNotContainRentalException(Throwable cause) {
        super(cause);
    }

}