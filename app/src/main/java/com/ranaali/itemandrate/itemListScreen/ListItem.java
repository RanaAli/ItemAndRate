package com.ranaali.itemandrate.itemListScreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ranaali.itemandrate.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ListItem extends RecyclerView.ViewHolder {

    public static final String STRING_SPACE = " ";
    @BindView(R.id.listItemViewTitleTextView)
    protected TextView mTitleTextView;

    @BindView(R.id.listItemCountTextView)
    protected TextView mCountTextView;

    private ArrayList<Item> mItems;

    private ListItemInterface mListItemInterface;

    ListItem(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void populate(String key, ArrayList<Item> items) {
        mItems = items;

        mTitleTextView.setText(key);
        mCountTextView.setText(items.size()
                + STRING_SPACE + itemView.getResources().getString(R.string.transactions));

        itemView.setOnClickListener(itemClickListener);
    }

    private View.OnClickListener itemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mListItemInterface != null) {
                mListItemInterface.onItemClicked(mItems);
            }
        }
    };

    public void setListItemInterface(ListItemInterface listItemInterface) {
        this.mListItemInterface = listItemInterface;
    }

    public interface ListItemInterface {
        void onItemClicked(ArrayList<Item> items);
    }

}
