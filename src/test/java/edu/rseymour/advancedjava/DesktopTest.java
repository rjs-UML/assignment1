package edu.rseymour.advancedjava;

import edu.rseymour.advancedjava.datamodels.*;
import edu.rseymour.advancedjava.exceptionhandlers.InvalidDataException;
import edu.rseymour.advancedjava.exceptionhandlers.PowerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit tests for Desktop class.
 *
 * @author Ryan Seymour
 */

public class DesktopTest {

    private Desktop desktop;
    private Monitor monitor;
    private SystemUnit systemUnit;
    private Keyboard keyboard;
    private Mouse mouse;

    /**
     * Configures a desktop object to run Junit tests. Creates and
     * injects Monitor, SystemUnit, Keyboard, and Mouse objects to create
     * Desktop test instance.
     */
    @Before
    public void setup() {
        monitor = new Monitor("Dell", 27);
        systemUnit = new SystemUnit("Dell", 32);
        keyboard = new Keyboard("Logitech", true);
        mouse = new Mouse("3M", true);
        desktop = new Desktop(monitor, systemUnit, keyboard, mouse);
    }

    /**
     * Verifies {@link Desktop#validatePassword(String)}
     * correctly validates the stored password for this Desktop against the
     * string parameter.
     */
    @Test
    public void validatePasswordTest() throws InvalidDataException {
        desktop.setPassword("AdvancedJava");
        desktop.validatePassword("AdvancedJava");
        Assert.assertTrue(desktop.isLoggedIn());
    }

    /**
     * Verifies {@link Desktop#validatePassword(String)}
     * throws InvalidDataException.
     *
     * @throws InvalidDataException when the stored password for this Desktop
     * is not equal to the string parameter passed to validatePassword().
     */
    @Test (expected = InvalidDataException.class)
    public void validatePasswordExceptionTest() throws InvalidDataException {
        desktop.setPassword("AdvancedJava");
        desktop.validatePassword("Incorrect");
        Assert.assertFalse(desktop.isLoggedIn());
    }

    /**
     * Verifies that when isPoweredOn equals true, the desktop instance password
     * is set, and the String parameter passed to the logIn() method is
     * equal to the stored password for this Desktop.
     */
    @Test
    public void logInTest() throws PowerException, InvalidDataException {
        desktop.switchPower();
        desktop.setPassword("AdvancedJava");
        desktop.logIn("AdvancedJava");
        boolean test = desktop.isLoggedIn();
        Assert.assertTrue(test);
    }

    /**
     * Verifies that a PowerException is thrown if a user tries to log in
     * if isPoweredOn is false.
     *
     * @throws PowerException when isPoweredOn is false.
     */
    @Test (expected = PowerException.class)
    public void logInExceptionTest() throws PowerException, InvalidDataException {
        desktop.setPassword("AdvancedJava");
        desktop.logIn("AdvancedJava");
    }

    /**
     * Verifies that {@link Desktop#setPassword(String)} validates the stored
     * password for the desktop instance equals the String parameter passed
     * to {@link Desktop#setPassword(String)}.
     *
     * @throws InvalidDataException
     */
    @Test
    public void setPasswordTest() throws InvalidDataException {
        desktop.setPassword("AdvancedJava");
        Assert.assertEquals("AdvancedJava", desktop.getPassword());
    }

    /**
     * Verifies that an InvalidDataException is thrown if the stored password
     * for he desktop instance is not equal to the String parameter passed
     * to {@link Desktop#setPassword(String)}.
     * @throws InvalidDataException
     */
    @Test(expected = InvalidDataException.class)
    public void setPasswordExceptionTest() throws InvalidDataException {
        desktop.setPassword("ThisIsLongerThan15Characters");
        desktop.setPassword("short");
    }
}