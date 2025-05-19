package com.rochelle.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Login class.
 */
public class ChatAppTest {

    @Test
    public void testValidUsername() {
        Login login = new Login("user$name", "Password1@");
        assertTrue(login.checkUsername(), "Username is valid because it contains '$'");
    }

    @Test
    public void testInvalidUsernameSpecialChar() {
        Login login = new Login("username", "Password1@");
        assertFalse(login.checkUsername(), "Username is invalid because it does not contain '$'");
    }

    @Test
    public void testInvalidUsernameLength() {
        Login login = new Login("username$12345", "Password1@");
        assertFalse(login.checkUsername(), "Username is invalid because it is too long");
    }

    @Test
    public void testInvalidPasswordDigit() {
        Login login = new Login("user$name", "Password@");
        assertFalse(login.checkPassword(), "Password is invalid because it is missing a digit");
    }

    @Test
    public void testInvalidPasswordLength() {
        Login login = new Login("user$name", "Pass@1");
        assertFalse(login.checkPassword(), "Password is invalid because it is too short");
    }

    @Test
    public void testInvalidPasswordUpperCase() {
        Login login = new Login("user$name", "password@1");
        assertFalse(login.checkPassword(), "Password is invalid because it is missing an uppercase letter");
    }

    @Test
    public void testLoginUserSuccess() {
        String username = "user$name";
        String password = "Password1@";
        Login login = new Login(username, password);
        boolean loginStatus = login.loginUser(username, password);
        assertTrue(loginStatus, "Login is successful because credentials are valid");
    }

    @Test
    public void testLoginUserFailure() {
        String username = "user$name";
        String password = "Password1@";
        Login login = new Login(username, password);
        boolean loginStatus = login.loginUser("wrong$name", "wrongPassword");
        assertFalse(loginStatus, "Login is unsuccessful because credentials are invalid");
    }

    @Test 
    public void testReturnLoginSuccess() {
        Login login = new Login("user$name", "Password1@");
        String message = login.returnLogin(true);
        assertEquals("Welcome user", message, "Return Login should welcome the user");
    }

    @Test 
    public void testReturnLoginFailure() {
        Login login = new Login("user$name", "Password1@");
        String message = login.returnLogin(false);
        assertEquals("Login failed", message, "Return Login should indicate failure");
    }
}
