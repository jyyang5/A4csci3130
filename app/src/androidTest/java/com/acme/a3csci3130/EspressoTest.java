package com.acme.a3csci3130;

/**
 * Created by JingyunYang on 2018/2/7.
 */

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

//@RunWith(AndroidJUnit4.class)
//@LargeTest
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> myActivityRule = new ActivityTestRule<>(MainActivity.class);


    //Rule run in order of alphabet
    //createContact
    @Test
    public void check1_create() {
        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name)).perform(typeText("Mike"));//satisfy 2 conditions
        onView(withId(R.id.businessNum)).perform(typeText("111111111"));
        onView(withId(R.id.provience)).perform(typeText("NS"));
        onView(withId(R.id.primrayBusiness)).perform(typeText("Fisher"));
        onView(withId(R.id.address)).perform(typeText("6027 Coburg Rd."));
        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click());
    }

    //Rule run in order of alphabet
    @Test
    //readContact
    public void check2_read() throws InterruptedException {
        Thread.sleep(1500);

        onView(withId(R.id.listView)).check(matches(isDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform((click()));

        onView(withId(R.id.name1)).check(matches(withText("Mike")));//satisfy 2 conditions
        onView(withId(R.id.businessNum)).check(matches(withText("111111111")));
        onView(withId(R.id.provience)).check(matches(withText("NS")));
        onView(withId(R.id.primrayBusiness)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("6027 Coburg Rd.")));

    }


    //need to erase the previous content
    //updateCheck
    @Test
    public void check3_upda() throws InterruptedException {
        Thread.sleep(1500);

        //go to the contact created
        onView(withId(R.id.listView)).check(matches(isDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform((click()));

        onView(withId(R.id.businessNum)).perform(replaceText("222222222"));//satisfy 4 conditions
        closeSoftKeyboard();

        onView(withId(R.id.updateButton)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform((click()));
        onView(withId(R.id.businessNum)).check(matches(withText("222222222")));

    }


    @Test
    public void check4_delete() {
        onView(withId(R.id.listView)).check(matches(isDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform((click()));
        onView(withId(R.id.deleteButton));
    }

}