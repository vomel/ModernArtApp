package com.ivzar.vomel.modernartapp;

import org.junit.Test;

import static com.ivzar.vomel.modernartapp.MainActivity.getNewColor;
import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void color_change_isCorrect() throws Exception {
        assertEquals(0, getNewColor(0, 0));
        assertEquals(63, getNewColor(25, 0));
        assertEquals(127, getNewColor(50, 0));
        assertEquals(191, getNewColor(75, 0));
        assertEquals(255, getNewColor(100, 0));

        assertEquals(100, getNewColor(0, 100));
        assertEquals(138, getNewColor(25, 100));
        assertEquals(177, getNewColor(50, 100));
        assertEquals(216, getNewColor(75, 100));
        assertEquals(255, getNewColor(100, 100));

        assertEquals(255, getNewColor(0, 255));
        assertEquals(255, getNewColor(25, 255));
        assertEquals(255, getNewColor(50, 255));
        assertEquals(255, getNewColor(75, 255));
        assertEquals(255, getNewColor(100, 255));
    }
}