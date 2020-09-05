package edu.rseymour.advancedjava.datamodels;

public abstract class Keyboard {

    private String brand;
    private boolean isWireless;

    public Keyboard(String brand, boolean isWireless) {
        this.brand = brand;
        this.isWireless = isWireless;
    }
}
