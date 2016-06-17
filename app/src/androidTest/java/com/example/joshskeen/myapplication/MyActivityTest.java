package com.example.joshskeen.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MyActivityTest
{
    @Rule
    public ActivityTestRule<MyActivity> mActivityRule = new ActivityTestRule<>(
            MyActivity.class);

    @Test
    public void testMyActivityAppearsAsExpectedInitially()
    {
        MyActivity mActivity = (MyActivity) mActivityRule.getActivity();
        onView(withId(R.id.clickMeBtn)).check(matches(withText("Click me!")));
        onView(withId(R.id.helloWorldTextView)).check(matches(withText("Hello world!")));
    }

    @Test
    public void testClickingClickMeButtonChangesHelloWorldText()
    {
        MyActivity mActivity = (MyActivity) mActivityRule.getActivity();
        onView(withId(R.id.helloWorldTextView)).check(matches(withText("Hello world!")));
        onView(withId(R.id.clickMeBtn)).perform(click());
        onView(withId(R.id.helloWorldTextView)).check(matches(withText("HEY WORLD")));
    }

}