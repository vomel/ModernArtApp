package com.ivzar.vomel.modernartapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ProgressBar;

import com.robotium.solo.Solo;

/**
 * Created by vomel on 26/12/2016.
 */

public class SeekBarTest extends
        ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public SeekBarTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Executes the MoreInfo Test
    public void testRun() {

        int delay = 2000;

        // Wait for activity: 'MainActivity'
        assertTrue("MoreInfoTest failed:MainActivity did not load correctly.",
                solo.waitForActivity(MainActivity.class, delay));

        ProgressBar seekBar = (ProgressBar) solo.getView(R.id.seek_bar);

        assertEquals(0, seekBar.getProgress());
        solo.setProgressBar(seekBar, 10);
        assertEquals(0, seekBar.getProgress());

        solo.sleep(delay);
        //TODO continue ...
    }

}

