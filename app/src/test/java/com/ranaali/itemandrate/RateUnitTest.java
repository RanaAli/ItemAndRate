package com.ranaali.itemandrate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import models.Rate;
import utils.Currencies;
import utils.RateCalculator;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RateUnitTest {
    @Test
    public void rateCalculatedAsExpectedUS() {
        Gson gson = new Gson();
        ArrayList<Rate> rates = gson.fromJson(RateTestData.TEST_1,
                new TypeToken<List<Rate>>() {
                }.getType());

        RateCalculator.prepareRateData(rates);

        String conversion = RateCalculator.convertToGBP("30.1", Currencies.USD);
        assertEquals("23.177", conversion);
    }

    @Test
    public void rateCalculatedAsExpectedCAD() throws Exception {
        Gson gson = new Gson();
        ArrayList<Rate> rates = gson.fromJson(RateTestData.TEST_1,
                new TypeToken<List<Rate>>() {
                }.getType());

        RateCalculator.prepareRateData(rates);

        String conversion = RateCalculator.convertToGBP("33.6", Currencies.CAD);
        assertEquals("23.80224", conversion);
    }
}