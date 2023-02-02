package com.example.sicelo.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class PersonIdMismatchException extends Exception {

    public PersonIdMismatchException() {
        super();
    }

    public PersonIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PersonIdMismatchException(final String message) {
        super(message);
    }

    public PersonIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
