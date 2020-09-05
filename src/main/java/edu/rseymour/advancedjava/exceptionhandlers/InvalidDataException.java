package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception that is thrown when user-provided String value
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
