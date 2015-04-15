package com.example.joshskeen.myapplication;

import android.support.test.espresso.assertion.ViewAssertions;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MyActivityEspressoTest extends ActivityInstrumentationTestCase2<MyActivity> {

    public MyActivityEspressoTest() {
        super(MyActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testBasicLayout() throws Exception {
        onView(withId(R.id.clickMeBtn)).check(ViewAssertions.matches(withText("Click me!")));
    }
}