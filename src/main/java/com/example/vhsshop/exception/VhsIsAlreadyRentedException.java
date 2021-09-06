package com.example.vhsshop.exception;

public class VhsIsAlreadyRentedException extends RuntimeException{

    public VhsIsAlreadyRentedException(String message) {
        super(message);
    }

    public VhsIsAlreadyRentedException(String message, Throwable cause) {
        super(message, cause);
    }

    public VhsIsAlreadyRentedException(Throwable cause) {
        super(cause);
    }
}
