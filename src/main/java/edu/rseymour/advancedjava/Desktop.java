package edu.rseymour.advancedjava;
import edu.rseymour.advancedjava.datamodels.*;
import edu.rseymour.advancedjava.exceptionhandlers.InvalidDataException;
import edu.rseymour.advancedjava.exceptionhandlers.PowerException;

/**
 * Desktop class that creates a desktop computer with a monitor, system unit,
 * keyboard, and mouse.
 *
 * Can power on, set password, and login.
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
     * Class contructor that returns a desktop computer consisting of a monitor,
     * system unit, keyboard, and mouse. You must set the password the first time
     * you log in.
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
     * @return true if the desktop is logged in, false if the
     * desktop is logged out.
     */
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    /**
     * Logs the user into the desktop computer. The first time the user
     * logs in, the user must set the password. After the first time the
     * user logs in, the password is validated using the stored password
     * for the desktop instance.
     *
     * @param mPassword the password the user enters to log in to the
     *                  desktop. Must be equal to the current password
     *                  value for the desktop instance.
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
     * Sets the desktop instance password.
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
     * password for the desktop instance.
     * @param mPassword a password that meets the minimum requirements as
     *                  defined by setPassword().
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