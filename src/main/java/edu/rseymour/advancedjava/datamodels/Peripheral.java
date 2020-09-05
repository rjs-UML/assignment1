package edu.rseymour.advancedjava.datamodels;

/**
 * Minimal abstract class to defined wired or wireless
 * desktop computer peripherals.
 */
public abstract class Peripheral {

    private String brand;
    private boolean isWireless;

    public Peripheral(){};

    public Peripheral(String brand, boolean isWireless) {
        this.brand = brand;
        this.isWireless = isWireless;
    }
}
