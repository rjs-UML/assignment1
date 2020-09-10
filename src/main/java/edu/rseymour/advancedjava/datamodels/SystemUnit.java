package edu.rseymour.advancedjava.datamodels;

/**
 * Minimal SystemUnit class to demonstrate dependency injection.
 */
public class SystemUnit {

    private String brand;
    private int gbMemory;

    /**
     * Private no-arg constructor.
     */
    private SystemUnit(){};

    /**
     * Constructor for Monitor instance. Returns a SystemUnit
     * instance with a defined amount of memory in gigabytes
     * and a manufacturer.
     * @param brand
     * @param gbOfMemory
     */
    public SystemUnit(String brand, int gbOfMemory) {
        this.brand = brand;
        this.gbMemory = gbOfMemory;
    }
}
