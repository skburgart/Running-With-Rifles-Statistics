package com.skburgart.rwr.vo;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class PlayerTest {

    @Test
    public void testElapsedString() throws Exception {

        final int SEC_PER_MIN = 60;
        final int SEC_PER_HOUR = 60 * SEC_PER_MIN;
        final int SEC_PER_DAY = 24 * SEC_PER_HOUR;

        assertEquals(Player.elapsedString(0), "0 min");
        assertEquals(Player.elapsedString(SEC_PER_MIN - 1), "0 min");
        assertEquals(Player.elapsedString(SEC_PER_MIN), "1 min");
        assertEquals(Player.elapsedString(SEC_PER_MIN + 1), "1 min");
        assertEquals(Player.elapsedString(SEC_PER_MIN * 5), "5 mins");
        assertEquals(Player.elapsedString(SEC_PER_HOUR - 1), "59 mins");
        assertEquals(Player.elapsedString(SEC_PER_HOUR), "1 hour");
        assertEquals(Player.elapsedString(SEC_PER_HOUR * 5), "5 hours");
        assertEquals(Player.elapsedString(SEC_PER_DAY - 1), "23 hours");
        assertEquals(Player.elapsedString(SEC_PER_DAY), "1 day");
        assertEquals(Player.elapsedString(SEC_PER_DAY * 5), "5 days");
    }
}