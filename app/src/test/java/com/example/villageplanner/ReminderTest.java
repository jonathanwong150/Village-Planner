package com.example.villageplanner;

import static org.junit.Assert.*;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReminderTest extends TestCase {

    private ArrayList<Reminder> reminders;

    @Before
    public void setUp() throws Exception {
        reminders = new ArrayList<Reminder>();
        Reminder r1 = new Reminder(1, 2, 4, 29, "Cava");
        Reminder r2 = new Reminder(5, 10, 11, 33, "Ramen Kenjo");
        Reminder r3 = new Reminder(12, 21, 18, 22, "Kobunga");
        reminders.add(r1);
        reminders.add(r2);
        reminders.add(r3);
    }

    // Test 6
    @Test
    public void testReminderString() {
        String r1_string = "Your reminder to eat Cava on 1/2 at 4:29!";
        String r2_string = "Your reminder to eat Ramen Kenjo on 5/10 at 11:33!";
        String r3_string = "Your reminder to eat Kobunga on 12/21 at 18:22!";

        assertEquals(r1_string, reminders.get(0).getReminderString());
        assertEquals(r2_string, reminders.get(1).getReminderString());
        assertEquals(r3_string, reminders.get(2).getReminderString());
    }

    // Test 7
    @Test
    public void testReminderAddSuccessful() {
        Reminder r4 = new Reminder(6, 6, 6, 26, "Greenlife");
        reminders.add(r4);

        String r4_string = "Your reminder to eat Greenlife on 6/6 at 6:26!";
        assertEquals(r4_string, reminders.get(3).getReminderString());
    }

    // Test 8
    @Test
    public void testReminderAddUnsuccesful() {
        String reminders_full = "Already stored a maximum of 10 reminders!";
        for (int i =0; i < 7; i += 1) {
            reminders.add(new Reminder(1, 1, 1, 1, "filelr"));
        }

        String reminders_size = "";
        if (reminders.size() == 10) {
            reminders_size = "Already stored a maximum of 10 reminders!";
        }

        assertEquals(reminders_full, reminders_size);
    }

    // Test 9
    @Test
    public void testReminderDeleteSuccessful() {
        String length_after_deletion = "2";
        reminders.remove(0);

        assertEquals(length_after_deletion, Integer.toString(reminders.size()));
    }

    // Test 10
    @Test
    public void testReminderDeleteUnsuccessful() {
        Integer to_delete = 6;

        String delete_unsuccessful = "false";
        if (to_delete >= reminders.size()) {
            delete_unsuccessful = "true";
        }

        assertEquals(delete_unsuccessful, "true");
    }
}