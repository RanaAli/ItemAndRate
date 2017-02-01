package com.ranaali.itemandrate.itemdetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranaali.itemandrate.R;

import java.util.ArrayList;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemDetailAdaptor extends RecyclerView.Adapter<DetailItem> {
    private ArrayList<Item> mItemArrayList;

    public ItemDetailAdaptor(ArrayList<Item> itemArrayList) {
        mItemArrayList = itemArrayList;
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
    }

    @Override
    public DetailItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);

        return new DetailItem(view);

    }

    @Override
    public void onBindViewHolder(DetailItem holder, int position) {
        holder.populate(mItemArrayList.get(position));

    }

}
