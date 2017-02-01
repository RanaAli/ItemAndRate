package utils;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Rate;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class RateCalculator {

    public static String RES_RAW_RATES_JSON = "res/raw/rates.json";
    private static HashMap<String, String> mToGBPRatesHashMap;
    private static HashMap<String, String> mToUSDRatesHashMap;

    public static void prepareRateData() {
        mToGBPRatesHashMap = new HashMap<>();
        mToUSDRatesHashMap = new HashMap<>();

        ArrayList<Rate> rates = getRateData();

        if (rates != null) {
            for (Rate rate : rates) {
                if (rate.getTo().equalsIgnoreCase(Currencies.GBP.getCode())) {

                    if (!mToGBPRatesHashMap.containsKey(rate.getFrom())) {
                        mToGBPRatesHashMap.put(rate.getFrom(), rate.getRate());
                    }
                } else if (rate.getTo().equalsIgnoreCase(Currencies.USD.getCode())) {

                    if (!mToUSDRatesHashMap.containsKey(rate.getFrom())) {
                        mToUSDRatesHashMap.put(rate.getFrom(), rate.getRate());
                    }
                }
            }
        }
    }

    @Nullable
    public static ArrayList<Rate> getRateData() {
        Gson gson = new Gson();
        return gson.fromJson(new FileIO().readFile(RES_RAW_RATES_JSON),
                new TypeToken<List<Rate>>() {
                }.getType());
    }

    public static String convertToGBP(String originalPrice,
                                      Currencies originalCurrency) {
        if (mToGBPRatesHashMap == null) {
            prepareRateData();
        }

        if (originalCurrency == null) {
            return null;
        }

        if (originalCurrency == Currencies.GBP) {
            return originalPrice;
        }

        String rateString = mToGBPRatesHashMap.get(originalCurrency.getCode());

        if (rateString == null) {

            String rateStringToUSD = mToUSDRatesHashMap.get(originalCurrency.getCode());

            if (rateStringToUSD == null) {
                return null;
            }

            BigDecimal rate = new BigDecimal(rateStringToUSD);
            BigDecimal priceBD = new BigDecimal(originalPrice);

            originalPrice = priceBD.multiply(rate).toString();

            rateString = mToGBPRatesHashMap.get(Currencies.USD.getCode());
        }

        BigDecimal rate = new BigDecimal(rateString);
        BigDecimal priceBD = new BigDecimal(originalPrice);

        return priceBD.multiply(rate).toString();
    }
}
