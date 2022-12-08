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
import static androidx.test.espresso.matcher.ViewMatchers.withId;


/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MapsActivityAndroidTestEspresso {
    /**
     * Use {@link ActivityScenarioRule} to create and launch the activity under test, and close it
     * after test completes.
     */
    @Test
    public void Test_Reminder() {
        // Type text and then press the button.
        onView(withId(R.id.button)).perform(click());
        // Check that the intent was passed
        Intents.init();
        intended(hasComponent(ReminderActivity.class.getName()));
    }
    @Test
    public void Test_Profile() {
        // Type text and then press the button.
        onView(withId(R.id.button3)).perform(click());
        // Check that the intent was passed
        Intents.init();
        intended(hasComponent(ProfileActivity.class.getName()));
    }
}
