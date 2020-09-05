package edu.rseymour.advancedjava.datamodels;

public abstract class Monitor {

    private String brand;
    private int size;

    public Monitor(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }
}
