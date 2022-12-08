package com.example.villageplanner;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class UserTest extends TestCase {

    private String user_key = "";
    private User testUserCorrect;
    private User testUserIncorrect;

    @Before
    public void setUp() throws Exception {
        testUserCorrect = new User("test@usc.edu", "testpassword", "NGGD5Z-0hHqNb5nMREa");
        testUserIncorrect = new User("nonexistent@usc.edu", "nonexistent", "");
    }


    // Test 1
    @Test
    public void testRegistrationSuccessful() {
        // Nonexistent email and nonexistent login details
        String emailString = "";
        String passwordString = "";
        assertNotEquals(testUserIncorrect.getUsername(), emailString);
        assertNotEquals(testUserIncorrect.getPassword(), passwordString);

        // Double checking there is a non-existent user key so we can therefore make this new user
        assertEquals(testUserIncorrect.getUser_key(), "");
    }

    // Test 2
    @Test
    public void testRegistrationFail() {
        // Registering new user with existing user email
        String emailString = "test@usc.edu";
        String passwordString = "testpassword";

        assertEquals(testUserCorrect.getUsername(), emailString);
        assertEquals(testUserCorrect.getPassword(), passwordString);

        // Since user already exists and returns a user_key, test registration fails
        // Checking correct user_key that would be returned by Firebase
        String testusc_key = "NGGD5Z-0hHqNb5nMREa";
        assertEquals(testUserCorrect.getUser_key(), testusc_key);
    }

    // Test 3
    @Test
    public void testLoginSuccessful() {
        // Checking correct username and password that would be queried from Firebase
        String emailString = "test@usc.edu";
        String passwordString = "testpassword";
        assertEquals(testUserCorrect.getUsername(), emailString);
        assertEquals(testUserCorrect.getPassword(), passwordString);

        // Checking correct user_key that would be returned by Firebase
        String testusc_key = "NGGD5Z-0hHqNb5nMREa";
        assertEquals(testUserCorrect.getUser_key(), testusc_key);
    }

    // Test 4
    @Test
    public void testLoginUnsuccesfulInvalidUser() {

        // Nonexistent email and nonexistent login details
        String emailString = "";
        String passwordString = "";
        assertNotEquals(testUserIncorrect.getUsername(), emailString);
        assertNotEquals(testUserIncorrect.getPassword(), passwordString);

        // Double checking there is a non-existent user key
        assertEquals(testUserIncorrect.getUser_key(), "");
    }

    // Test 5
    @Test
    public void testLoginUnsuccesfulInvalidPassword() {

        // Nonexistent email and nonexistent login details
        String emailString = "";
        String passwordString = "";
        assertNotEquals(testUserIncorrect.getUsername(), emailString);
        assertNotEquals(testUserIncorrect.getPassword(), passwordString);

        // Double checking there is a non-existent user key
        assertEquals(testUserIncorrect.getUser_key(), "");
    }
}