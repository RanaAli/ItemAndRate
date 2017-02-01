package com.ranaali.itemandrate;

import android.os.Bundle;

import com.ranaali.itemandrate.applicationbase.BaseActivity;
import com.ranaali.itemandrate.itemListScreen.MainScreenFragment;
import com.ranaali.itemandrate.itemdetails.ItemDetailsActivity;

import java.util.ArrayList;

import models.Item;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();

        MainScreenFragment mainScreenFragment = new MainScreenFragment();
        mainScreenFragment.setMainScreenPresenterInterface(mainScreenFragmentInterface);

        addFragment(mainScreenFragment, savedInstanceState);
    }

    private MainScreenFragment.MainScreenFragmentInterface
            mainScreenFragmentInterface = new MainScreenFragment.MainScreenFragmentInterface() {
        @Override
        public void showItemDetails(ArrayList<Item> items) {
            startActivity(
                    ItemDetailsActivity.getItemDetailsActivityIntent(MainActivity.this, items));
        }
    };
}
