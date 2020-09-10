package edu.rseymour.advancedjava.datamodels;

/**
 * Minimal Keyboard class to demonstrate dependency injection. Extends
 * Peripheral abstract class.
 */
public class Keyboard extends Peripheral{

    private String brand;
    private boolean isWireless;

    /**
     * Private no-argument constructor.
     * @return
     */
    private Keyboard(){};

    /**
     * Constructor for Keyboard instance. Returns a wired or wireless
     * Keyboard instance with a defined manufacturer.
     * @param brand name of keyboard manufacturer.
     * @param isWireless determines if the keyboard instance connects
     *                   to the system unit with wifi or wired connection.
     */
    public Keyboard(String brand, boolean isWireless) {
        this.brand = brand;
        this.isWireless = isWireless;
    }
}
