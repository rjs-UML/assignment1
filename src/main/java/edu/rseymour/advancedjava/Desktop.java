package edu.rseymour.advancedjava;
import edu.rseymour.advancedjava.datamodels.*;

public class Desktop {

    private Monitor monitor;
    private Keyboard keyboard;
    private SystemUnit systemUnit;
    private Mouse mouse;
    private boolean isPoweredOn = false;
    private boolean isConnectedToInternet = false;
    private String password = null;

    public Desktop(Monitor monitor, Keyboard keyboard, SystemUnit systemUnit, Mouse mouse) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.systemUnit = systemUnit;
        this.mouse = mouse;
    }

    public void powerOn() {
        if (!isPoweredOn)
            this.isPoweredOn = true;
        System.out.println("It's already on!");
    }

    public void isConnectedToInternet() {
        if (!isPoweredOn)
            System.out.println("Not powered on!");
        else if (isPoweredOn) {
            this.isConnectedToInternet = true;
            System.out.println("You are connected!");
        }
    }

    public void setPassword(String password) {
        while(this.password == null) {
            System.out.println("Enter a password with no more than 15 characters:");
            if (password.length() <= 0 || password.length() > 15) {
                System.out.println("Invalid password. Try again");
            }
            this.password = password;
        }
    }
}