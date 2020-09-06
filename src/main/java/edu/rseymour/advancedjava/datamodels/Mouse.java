package edu.rseymour.advancedjava.datamodels;

/**
 * Minimal Mouse class to demonstrate dependency injection. Extends
 * Peripheral abstract class.
 */
public class Mouse extends Peripheral {

    private String brand;
    private boolean isWireless;

    /**
     * Private no-argument constructor.
     */
    private Mouse(){};

    /**
     * Constructor for Mouse instance.
     *
     * Returns a wired or wireless Mouse instance with a defined manufacturer.
     *
     * @param brand name of mouse manufacturer.
     * @param isWireless determines if the mouse instance connects
     *                   to the system unit using a wireless or wired connection.
     */
    public Mouse(String brand, boolean isWireless) {
        this.brand = brand;
        this.isWireless = isWireless;
    }
}
