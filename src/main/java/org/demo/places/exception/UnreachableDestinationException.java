package org.demo.places.exception;

public class UnreachableDestinationException extends RuntimeException {
    public UnreachableDestinationException(String message, Exception cause) {
        super(message, cause);
    }
}
