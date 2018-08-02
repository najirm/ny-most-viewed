package com.ny.mostviewed.activity;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.ny.mostviewed.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    private MainActivity mainActivity = null;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mainActivity = activityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view1 = mainActivity.findViewById(R.id.recyclerView);
        assertNotNull(view1);
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}
