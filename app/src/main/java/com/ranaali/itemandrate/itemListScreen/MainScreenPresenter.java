package com.ranaali.itemandrate.itemListScreen;

import java.util.ArrayList;
import java.util.HashMap;

import models.Item;
import utils.TransactionIO;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class MainScreenPresenter {

    MainScreenView mMainScreenView;

    public MainScreenPresenter(MainScreenView mMainScreenView) {
        this.mMainScreenView = mMainScreenView;

        HashMap<String, ArrayList<Item>> keyHashMap = TransactionIO.prepareData(
                mMainScreenView.getContext());

        ItemListAdaptor itemListAdaptor = new ItemListAdaptor(keyHashMap);

        mMainScreenView.populateList(itemListAdaptor);

    }


}
