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
public class LoginActivityAndroidTestEspresso {
    public static final String EMAIL = "test@usc.edu";
    public static final String PASS = "testpassword";
    public static final String SUCCESS = "Success!";
    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes.
     */
    @Test
    public void Test_Login() {
        // Type text and then press the button.
        onView(withId(R.id.editTextTextEmailAddress))
                .perform(typeText(EMAIL), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword))
                .perform(typeText(PASS), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.editTextTextPassword)).check(matches(withText(SUCCESS)));
    }
    @Test
    public void Test_Register() {
        // Type text and then press the button.
        onView(withId(R.id.editTextTextEmailAddress))
                .perform(typeText("register@usc.edu"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPassword))
                .perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.register)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.editTextTextPassword)).check(matches(withText(SUCCESS)));
    }
}
