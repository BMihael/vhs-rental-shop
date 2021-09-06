package com.example.vhsshop.exception;

public class RentalEndDateInvalidException extends RuntimeException{

    public RentalEndDateInvalidException(String message) {
        super(message);
    }

    public RentalEndDateInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentalEndDateInvalidException(Throwable cause) {
        super(cause);
    }
}