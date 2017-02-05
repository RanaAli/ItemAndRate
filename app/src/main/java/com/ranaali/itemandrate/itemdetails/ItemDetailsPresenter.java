package com.ranaali.itemandrate.itemdetails;

import java.math.BigDecimal;
import java.util.ArrayList;

import models.Item;
import utils.Currencies;
import utils.RateCalculator;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemDetailsPresenter {

    private ItemDetailsView mItemDetailsView;

    public ItemDetailsPresenter(ItemDetailsView mItemDetailsView) {
        this.mItemDetailsView = mItemDetailsView;
    }

    public void populate(ArrayList<Item> items) {

        BigDecimal totalAmount = new BigDecimal("0");

        for (Item item : items) {

            String priceInGBP = RateCalculator.convertToGBP(
                    item.getAmount(),
                    Currencies.getCurrency(item.getCurrency()));

            if(priceInGBP != null) {
                totalAmount = totalAmount.add(new BigDecimal(priceInGBP));
            }

            item.setAmountGBP(priceInGBP);

        }

        mItemDetailsView.setTotalAmount(totalAmount.toString());

        ItemDetailAdaptor itemDetailAdaptor = new ItemDetailAdaptor(items);

        mItemDetailsView.populateList(itemDetailAdaptor);
    }
}
