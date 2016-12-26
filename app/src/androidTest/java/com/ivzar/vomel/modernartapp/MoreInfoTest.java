package com.ivzar.vomel.modernartapp;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by vomel on 26/12/2016.
 */

public class MoreInfoTest extends
        ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MoreInfoTest() {
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

        // Click on menu item
        solo.clickOnMenuItem("More information");

        // Wait for 'More Information' dialog to open
        assertTrue("MoreInfoTest failed: More Information window did not load correctly.",
                solo.waitForDialogToOpen());

        // Click on NotNow
        solo.clickOnView(solo.getView(R.id.next_time));

        // Wait for activity: 'com.ivzar.vomel.modernartapp.MainActivity'
        assertTrue("MoreInfoTest failed: MainActivity did not correctly load.",
                solo.waitForActivity(
                        com.ivzar.vomel.modernartapp.MainActivity.class, delay));

        // Click on menu item again
        solo.clickOnMenuItem("More information");

        // Wait for 'More Information' dialog to open
        assertTrue("MoreInfoTest failed: More Information window did not load correctly.",
                solo.waitForDialogToOpen());


        // Click on NotNow
        solo.clickOnView(solo.getView(R.id.visit_now));


        // Wait for activity: 'com.android.internal.app.ChooserActivity'
        assertTrue("MoreInfoTest: ChooserActivity was not launched correctly",
                solo.waitForActivity("ChooserActivity", delay));

        assertTrue("MoreInfoTest: Browser was not found",
                solo.searchText("Browser", true));

        solo.clickOnMenuItem("Browser");

        solo.sleep(delay);
    }
}
