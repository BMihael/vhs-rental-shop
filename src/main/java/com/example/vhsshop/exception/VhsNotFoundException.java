package com.example.vhsshop.exception;

public class VhsNotFoundException extends RuntimeException{

    public VhsNotFoundException(String message) {
        super(message);
    }

    public VhsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VhsNotFoundException(Throwable cause) {
        super(cause);
    }
}