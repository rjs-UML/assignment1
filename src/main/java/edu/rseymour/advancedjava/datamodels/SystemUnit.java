package edu.rseymour.advancedjava.datamodels;

public abstract class SystemUnit {

    private String brand;
    private int gbOfMemory;

    public SystemUnit(String brand, int gbOfMemory) {
        this.brand = brand;
        this.gbOfMemory = gbOfMemory;
    }
}
