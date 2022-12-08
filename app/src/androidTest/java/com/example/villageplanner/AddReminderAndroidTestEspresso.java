package com.example.villageplanner;
import android.app.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddReminderAndroidTestEspresso {
    public static final String RES = "Cava";
    public static final String MONTH = "January";
    public static final String DAY = "11";
    public static final String HOUR = "10";
    public static final String MIN = "24";
    public static final String DELETE = "1";
    public static final String SUCCESS = "Success!";
    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes.
     */
    @Test
    public void Test_Add() {
        // Type text and then press the button.
        onView(withId(R.id.restaurantNameTextField))
                .perform(typeText(RES), closeSoftKeyboard());
        onView(withId(R.id.monthTextField))
                .perform(typeText(MONTH), closeSoftKeyboard());
        onView(withId(R.id.dayTextField))
                .perform(typeText(DAY), closeSoftKeyboard());
        onView(withId(R.id.hourTextField))
                .perform(typeText(HOUR), closeSoftKeyboard());
        onView(withId(R.id.minuteTextField))
                .perform(typeText(MIN), closeSoftKeyboard());
        onView(withId(R.id.addReminderButton)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.restaurantNameTextField)).check(matches(withText(SUCCESS)));
    }
    @Test
    public void Test_Delete() {
        // Type text and then press the button.
        onView(withId(R.id.deleteReminderTextField))
                .perform(typeText(DELETE), closeSoftKeyboard());
        onView(withId(R.id.deleteReminderButton)).perform(click());
        // Check that the text was changed.
        onView(withId(R.id.editTextTextPassword)).check(matches(withText(SUCCESS)));
    }
}
