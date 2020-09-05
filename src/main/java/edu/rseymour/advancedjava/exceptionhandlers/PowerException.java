package edu.rseymour.advancedjava.exceptionhandlers;

/**
 * Exception thrown when the user tries to perform
 * an operation that requires isPoweredOn be equal
 * to true for an instance of the Desktop class.
 */
public class PowerException extends Exception {

    public PowerException(){
        super();
    }

    public PowerException (String errorMessage) {
        super(errorMessage);
    }
}
