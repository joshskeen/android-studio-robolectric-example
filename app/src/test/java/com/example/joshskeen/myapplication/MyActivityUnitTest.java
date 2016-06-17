package com.example.joshskeen.myapplication;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by mcharland on 6/16/2016.
 */
public class MyActivityUnitTest
{
    @Test
    public void test()
    {
        MyActivity a = new MyActivity();
        assertNotNull(a);
    }
}
