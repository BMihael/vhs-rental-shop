package com.example.vhsshop.exception;

public class UserIsAdminException extends RuntimeException{

    public UserIsAdminException(String message) {
        super(message);
    }

    public UserIsAdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsAdminException(Throwable cause) {
        super(cause);
    }
}