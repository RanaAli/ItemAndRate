package com.ranaali.itemandrate.itemdetails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ranaali.itemandrate.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.Item;
import utils.Currencies;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class DetailItem extends RecyclerView.ViewHolder {

    public static final String STRING_SPACE = " ";
    @BindView(R.id.listItemViewTitleTextView)
    protected TextView mTitleTextView;

    @BindView(R.id.listItemCountTextView)
    protected TextView mConvertedPriceTextView;

    DetailItem(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void populate(Item item) {
        mTitleTextView.setText(item.getAmount() + STRING_SPACE + item.getCurrency());
        mConvertedPriceTextView.setText(item.getAmountGBP()
                + STRING_SPACE + Currencies.GBP.getCode());

    }
}
