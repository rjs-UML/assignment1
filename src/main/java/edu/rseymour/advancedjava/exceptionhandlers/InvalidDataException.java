package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception that is thrown when user-provided string value
 * does not meet requirements as defined by the method.
 */
public class InvalidDataException extends Exception {

    public InvalidDataException(){
        super();
    }

    public InvalidDataException (String errorMessage) {
        super(errorMessage);
    }
}
