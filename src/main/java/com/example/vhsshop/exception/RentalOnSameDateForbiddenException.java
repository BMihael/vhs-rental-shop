package com.example.vhsshop.exception;

public class RentalOnSameDateForbiddenException extends RuntimeException{

    public RentalOnSameDateForbiddenException(String message) {
        super(message);
    }

    public RentalOnSameDateForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalOnSameDateForbiddenException(Throwable cause) {
        super(cause);
    }
}