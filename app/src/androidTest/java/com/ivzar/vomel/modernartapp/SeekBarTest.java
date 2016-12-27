package com.ivzar.vomel.modernartapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ProgressBar;
import android.widget.TableRow;

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

    // Executes the SeekBarTest
    public void testRun() {

        int delay = 1000;

        // Wait for activity: 'MainActivity'
        assertTrue("MoreInfoTest failed:MainActivity did not load correctly.",
                solo.waitForActivity(MainActivity.class, delay));

        // Get SeekBar and start moving
        ProgressBar seekBar = (ProgressBar) solo.getView(R.id.seek_bar);

        assertEquals(0, seekBar.getProgress());

        assertColor("#105080", (TableRow) solo.getView(R.id.leftTop));
        assertColor("#9F2071", (TableRow) solo.getView(R.id.leftBottom));
        assertColor("#6F1031", (TableRow) solo.getView(R.id.rightTop));
        assertColor("#aaaaaa", (TableRow) solo.getView(R.id.rightMiddle));
        assertColor("#3F10f1", (TableRow) solo.getView(R.id.rightBottom));


        solo.setProgressBar(seekBar, 10);
        solo.sleep(delay);
        assertEquals(10, seekBar.getProgress());
        assertColor("#27618C", (TableRow) solo.getView(R.id.leftTop));
        assertColor("#A8367F", (TableRow) solo.getView(R.id.leftBottom));
        assertColor("#7D2745", (TableRow) solo.getView(R.id.rightTop));
        assertColor("#AAAAAA", (TableRow) solo.getView(R.id.rightMiddle));
        assertColor("#5227F2", (TableRow) solo.getView(R.id.rightBottom));

        solo.setProgressBar(seekBar, 30);
        solo.sleep(delay);
        assertEquals(30, seekBar.getProgress());
        assertColor("#5784A6", (TableRow) solo.getView(R.id.leftTop));
        assertColor("#BB629B", (TableRow) solo.getView(R.id.leftBottom));
        assertColor("#9A576E", (TableRow) solo.getView(R.id.rightTop));
        assertColor("#AAAAAA", (TableRow) solo.getView(R.id.rightMiddle));
        assertColor("#7857F5", (TableRow) solo.getView(R.id.rightBottom));

        solo.setProgressBar(seekBar, 70);
        solo.sleep(delay);
        assertEquals(70, seekBar.getProgress());
        assertColor("#B7CAD8", (TableRow) solo.getView(R.id.leftTop));
        assertColor("#E2BCD4", (TableRow) solo.getView(R.id.leftBottom));
        assertColor("#D3B7C1", (TableRow) solo.getView(R.id.rightTop));
        assertColor("#AAAAAA", (TableRow) solo.getView(R.id.rightMiddle));
        assertColor("#C5B7FA", (TableRow) solo.getView(R.id.rightBottom));

        solo.setProgressBar(seekBar, 100);
        solo.sleep(delay);
        assertEquals(100, seekBar.getProgress());
        assertColor("#FFFFFF", (TableRow) solo.getView(R.id.leftTop));
        assertColor("#FFFFFF", (TableRow) solo.getView(R.id.leftBottom));
        assertColor("#FFFFFF", (TableRow) solo.getView(R.id.rightTop));
        assertColor("#AAAAAA", (TableRow) solo.getView(R.id.rightMiddle));
        assertColor("#FFFFFF", (TableRow) solo.getView(R.id.rightBottom));
    }

    private static void assertColor(String colorString, TableRow view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        assertEquals(getMessage(colorString, color), Color.parseColor(colorString), color);
    }

    private static String getMessage(String colorString, int color) {
        return "Expected: " + colorString + " but got: #" +
                (Integer.toHexString(color).substring(2).toUpperCase());
    }

}

