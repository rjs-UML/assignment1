package edu.rseymour.advancedjava.datamodels;

public abstract class Mouse {

    private String brand;
    private boolean isWireless;

    public Mouse(String brand, boolean isWireless) {
        this.brand = brand;
        this.isWireless = isWireless;
    }
}
