package com.system.restaurant;

public class ValidCustomException extends RuntimeException {

    private static final long serialVersionUID = -2134529591645719226L;

    public ValidCustomException(String message) {
        super(message);
    }
    public ValidCustomException(String message, Throwable cause) {
        super(message, cause);
    }

}
