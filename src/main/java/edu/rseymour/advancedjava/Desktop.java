package edu.rseymour.advancedjava;
import edu.rseymour.advancedjava.datamodels.*;
import edu.rseymour.advancedjava.exceptionhandlers.InvalidDataException;
import edu.rseymour.advancedjava.exceptionhandlers.PowerException;

/**
 * The Desktop class creates a desktop computer with a monitor, system unit,
 * keyboard, and mouse.
 *
 * A Desktop instance can power on or off, set password, and login.
 */
public class Desktop {

    private Monitor monitor;
    private SystemUnit systemUnit;
    private Keyboard keyboard;
    private Mouse mouse;
    private boolean isPoweredOn;
    private boolean isLoggedIn;
    private String password;

    /**
     * Private no-argument constructor.
     */
    private Desktop(){};

    /**
     * Class constructor that returns a Desktop instance consisting of a monitor,
     * system unit, keyboard, and mouse.
     *
     * @param monitor a desktop monitor with a named brand and size.
     * @param systemUnit a system unit with a brand and gigabytes of memory.
     * @param keyboard a peripheral with a brand and wired or wireless connection.
     * @param mouse a peripheral with a brand and wired or wireless connection.
     */
    public Desktop(Monitor monitor, SystemUnit systemUnit, Keyboard keyboard, Mouse mouse) {
        this.monitor = monitor;
        this.systemUnit = systemUnit;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.isPoweredOn = false;
        this.isLoggedIn = false;
        this.password = "";
    }

    /**
     * @return true if the desktop is powered on, false if the
     * desktop is powered off.
     */
    public boolean isPoweredOn() {
        return this.isPoweredOn;
    }

    /**
     * Changes isPoweredOn to the opposite of its current setting.
     */
    public void switchPower() {
        if (!isPoweredOn)
            isPoweredOn = true;
        else
            isPoweredOn = false;
    }

    /**
     * @return true if this Desktop is logged in, false if this
     * Desktop is logged out.
     */
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    /**
     * Logs the user into this Desktop with a password.
     *
     * The first time this method is called, you must set the
     * password. After the first time the method is called,
     * the password verified using {@link #validatePassword(String)}
     * with the stored password for this Desktop.
     *
     * @param mPassword the password the user enters to log in to this
     *                  Desktop. Must be equal to the current password
     *                  value for this Desktop.
     * @throws PowerException if isPoweredOn is set to false.
     * @throws InvalidDataException if mPassword does not equal the stored
     * password for the desktop instance.
     */
    public void logIn(String mPassword) throws PowerException, InvalidDataException {
        if (!isPoweredOn)
            throw new PowerException("Not powered on!");

        if (password.equals("")) {
            setPassword(mPassword);
        } else
            validatePassword(mPassword);
    }

    /**
     * @return current password for the desktop instance.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password for this Desktop.
     *
     * @param password must be between 8 and 15 characters long.
     * @throws InvalidDataException if mPassword does not meet
     * minimum password requirements.
     */
    public void setPassword(String password) throws InvalidDataException {
        if (password.length() <= 8 || password.length() >= 15) {
            throw new InvalidDataException("Invalid password. Password must be between 8 and 15 characters.");
        } else
            this.password = password;
    }

    /**
     * Validates that the password used during login is equal to the stored
     * password for this Desktop.
     *
     * @param mPassword a password that meets the minimum requirements as
     *                  defined by the {@link #setPassword(String)} method.
     * @throws InvalidDataException if mPassword is not equal to the stored
     * password for the desktop instance.
     */
    public void validatePassword(String mPassword) throws InvalidDataException {
        if (password.equals(mPassword)) {
            this.isLoggedIn = true;
            System.out.println("Logged in!");
        } else {
            throw new InvalidDataException("Incorrect password.");
        }
    }
}