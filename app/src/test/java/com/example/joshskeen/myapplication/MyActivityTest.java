package com.example.joshskeen.myapplication;

import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(MyCustomGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class MyActivityTest {

    private static final String TAG = MyActivityTest.class.getSimpleName();

    private MyActivity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MyActivity.class).create().get();
    }

    @Test
    public void myActivityAppearsAsExpectedInitially() {
        assertThat(mActivity.mClickMeButton).hasText("Click me!");
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
    }

    @Test
    public void clickingClickMeButtonChangesHelloWorldText() {
        assertThat(mActivity.mHelloWorldTextView).hasText("Hello world!");
        mActivity.mClickMeButton.performClick();
        assertThat(mActivity.mHelloWorldTextView).hasText("HEY WORLD");
    }

    @Test
    public void testBuildConfig() throws Exception {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "testing debug build config");
            assertThat(mActivity.mBuildConfigTextView).hasText("build type: debug");
        } else {
            Log.d(TAG, "testing release build config");
            assertThat(mActivity.mBuildConfigTextView).hasText("build type: release");
        }
    }

    @Test
    public void testProductFlavor() throws Exception {

    }
}