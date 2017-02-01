package com.ranaali.itemandrate;

import org.junit.Test;

import java.util.ArrayList;

import models.Rate;

import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RateUnitTest {
    @Test
    public void rateDataIsLoaded() throws Exception {
       ArrayList<Rate> rates = TestRateCalculator.getRateData();

        assertNotNull(rates);
    }

    @Test
    public void rateDataSize() throws Exception {
        ArrayList<Rate> rates = TestRateCalculator.getRateData();

        assertNotNull(rates);
    }
}