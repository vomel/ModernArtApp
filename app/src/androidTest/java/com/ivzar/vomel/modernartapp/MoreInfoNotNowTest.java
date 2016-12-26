package com.ivzar.vomel.modernartapp;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by vomel on 26/12/2016.
 */

public class MoreInfoNotNowTest extends
        ActivityInstrumentationTestCase2<MainActivity> {
    private Solo solo;

    public MoreInfoNotNowTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    // Executes the CancelTest
    public void testRun() {

        int delay = 2000;

        // Wait for activity: 'MainActivity'
        assertTrue("CancelTest failed:" +
                        "Section One:" +
                        "MainActivity did not load correctly.",
                solo.waitForActivity(MainActivity.class, delay));

        // Click on action bar item
//        solo.clickOnActionBarItem(0x1);

//        solo.sleep(delay);

        // Click on Action Bar
        solo.clickOnMenuItem("More information");
//        solo.clickOnView(solo.getView(R.id.toolbar));
//        solo.clickOnView(solo.getView(R.id.action_settings));

        // Wait for 'More Information' dialog to open
        assertTrue("CancelTest failed:" +
                        "Section One:" +
                        "More Information window did not load correctly.",
                solo.waitForDialogToOpen());

        // Click on NotNow
        solo.clickOnView(solo.getView(R.id.next_time));

        // Wait for activity: 'com.ivzar.vomel.modernartapp.MainActivity'
        assertTrue("Cancel test failed:" + "Section One:"
                        + "MainActivity did not correctly load.",
                solo.waitForActivity(
                        com.ivzar.vomel.modernartapp.MainActivity.class, delay));

        // Click on Action Bar
        solo.clickOnMenuItem("More information");

        // Wait for 'More Information' dialog to open
        assertTrue("CancelTest failed:" +
                        "Section One:" +
                        "More Information window did not load correctly.",
                solo.waitForDialogToOpen());


        // Click on NotNow
        solo.clickOnView(solo.getView(R.id.visit_now));

        solo.sleep(delay);


        // Wait for activity: 'com.android.internal.app.ChooserActivity'
        assertTrue(
                "ImplicitTest:" +
                        "Section One:" +
                        "ChooserActivity was not launched correctly",
                solo.waitForActivity("ChooserActivity", delay));

        assertTrue(
                "ImplicitTest:" +
                        "Section One:" +
                        "Browser was not found",
                solo.searchText("Browser", true));


/*
        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        // Enter the text: 't3'
        solo.clearEditText((android.widget.EditText) solo
                .getView(com.ivzar.vomel.modernartapp.R.id.title));

        solo.enterText((android.widget.EditText) solo
                .getView(com.ivzar.vomel.modernartapp.R.id.title), "t3");

        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        // Click on Done:
        solo.clickOnView(solo.getView(com.ivzar.vomel.modernartapp.R.id.statusDone));

        // Click on High
        solo.clickOnView(solo
                .getView(com.ivzar.vomel.modernartapp.R.id.highPriority));

        // Click on Cancel
        solo.clickOnView(solo
                .getView(com.ivzar.vomel.modernartapp.R.id.cancelButton));

        // Wait for activity: 'com.ivzar.vomel.modernartapp.AddToDoActivity'
        assertTrue("Cancel test failed:" + "Section One:"
                        + "AddToDoActivity did not correctly load.",
                solo.waitForActivity(
                        com.ivzar.vomel.modernartapp.AddToDoActivity.class, delay));

        // Click on Add New ToDo Item
        solo.clickOnView(solo.getView(com.ivzar.vomel.modernartapp.R.id.footerView));

        // Wait for activity: 'com.ivzar.vomel.modernartapp.AddToDoActivity'
        assertTrue("CancelTest failed:" +
                        "Section One:" +
                        "AddToDoActivity did not load correctly.",
                solo.waitForActivity(com.ivzar.vomel.modernartapp.AddToDoActivity.class));

        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        // Enter the text: 't4'
        solo.clearEditText((android.widget.EditText) solo
                .getView(com.ivzar.vomel.modernartapp.R.id.title));

        solo.enterText((android.widget.EditText) solo
                .getView(com.ivzar.vomel.modernartapp.R.id.title), "t4");

        // Hide the soft keyboard
        solo.hideSoftKeyboard();

        // Click on Done:
        solo.clickOnView(solo.getView(com.ivzar.vomel.modernartapp.R.id.statusDone));

        // Click on Low
        solo.clickOnView(solo.getView(com.ivzar.vomel.modernartapp.R.id.lowPriority));

        // Click on Submit
        solo.clickOnView(solo
                .getView(com.ivzar.vomel.modernartapp.R.id.submitButton));

        // ================ Section Two ===================

        // Wait for activity: 'MainActivity'
        assertTrue("CancelTest failed:" +
                        "Section Two:" +
                        "ToDoManagerActivity did not load correctly.",
                solo.waitForActivity(MainActivity.class));

        assertFalse("CancelTest failed:" +
                        "Section Two:" +
                        "Did not correctly cancel the creation of a ToDo Task.",
                solo.searchText("t3"));

        assertTrue("CancelTest failed:" +
                        "Section Two:" +
                        "Did not correctly set title of ToDo Task following cancel.",
                solo.searchText("t4"));

        assertTrue("CancelTest failed:" +
                        "Section Two:" +
                        "Did not correctly set priority of ToDo Task following cancel.",
                solo.searchText("[lL][oO][wW]"));

 */
    }
}
