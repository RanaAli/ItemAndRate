package com.ranaali.itemandrate.itemdetails;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranaali.itemandrate.R;
import com.ranaali.itemandrate.applicationbase.BaseFragment;

import org.parceler.Parcels;

import java.util.ArrayList;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemDetailsFragment extends BaseFragment {

    public static final String INTENT_DATA = "data";

    private ItemDetailsPresenter mItemDetailsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.details_fragment_layout, container, false);

        Bundle bundle = getArguments();

        ItemDetailsView itemDetailsView = new ItemDetailsView(view);
        mItemDetailsPresenter = new ItemDetailsPresenter(itemDetailsView);

        if (bundle.containsKey(INTENT_DATA)) {
            ArrayList<Item> items = Parcels.unwrap(bundle.getParcelable(INTENT_DATA));
            mItemDetailsPresenter.populate(items);
        }


        return view;
    }
}
