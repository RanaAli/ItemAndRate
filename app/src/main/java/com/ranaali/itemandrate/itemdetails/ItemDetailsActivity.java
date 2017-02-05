package com.ranaali.itemandrate.itemdetails;

import android.content.Intent;
import android.os.Bundle;

import com.ranaali.itemandrate.applicationbase.BaseActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemDetailsActivity extends BaseActivity {

    public static final String INTENT_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ItemDetailsFragment itemDetailsFragment = new ItemDetailsFragment();

        if (getIntent().hasExtra(INTENT_DATA)) {
            Bundle bundle = getIntent().getExtras();

            itemDetailsFragment.setArguments(bundle);
        }

        setContentView();
        addFragment(itemDetailsFragment, savedInstanceState);
    }

    public static Intent getItemDetailsActivityIntent(BaseActivity activity, ArrayList<Item> items) {
        Intent intent = new Intent(activity, ItemDetailsActivity.class);
        intent.putExtra(INTENT_DATA, Parcels.wrap(items));
        return intent;
    }
}
