package com.ranaali.itemandrate;

import java.io.File;
import java.util.Arrays;

import utils.RateCalculator;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class TestRateCalculator extends RateCalculator {
    TestRateCalculator() {
        RES_RAW_RATES_JSON = resolveBasePath() + "rates.json";
    }

    private static String resolveBasePath() {
        final String path = "./mymodule/src/test/resources/";
        if (Arrays.asList(new File("./").list()).contains("mymodule")) {
            return path;
        }
        return "../" + path;
    }
}
