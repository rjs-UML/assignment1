package edu.rseymour.advancedjava.datamodels;

/**
 * Minimal Monitor class to demonstrate dependency injection.
 */
public class Monitor {

    private String brand;
    private int size;

    /**
     * Private no-argument constructor.
     */
    private Monitor(){};

    /**
     * Constructor for Monitor instance. Returns a Monitor
     * instance with a defined size and manufacturer.
     * @param brand
     * @param size
     */
    public Monitor(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }
}
