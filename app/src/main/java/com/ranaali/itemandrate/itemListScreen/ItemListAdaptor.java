package com.ranaali.itemandrate.itemListScreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranaali.itemandrate.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemListAdaptor extends RecyclerView.Adapter<ListItem> {
    private HashMap<String, ArrayList<Item>> mItemsHashMap;
    private String[] keyList;

    private ListAdapterInterface mListAdapterInterface;

    public ItemListAdaptor(HashMap<String, ArrayList<Item>> itemsHashMap) {
        this.mItemsHashMap = itemsHashMap;

        Set<String> keySet = itemsHashMap.keySet();
        keyList = keySet.toArray(new String[keySet.size()]);
    }

    @Override
    public int getItemCount() {
        return mItemsHashMap.size();
    }

    @Override
    public ListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.list_item_view, parent, false);

        return new ListItem(view);

    }

    @Override
    public void onBindViewHolder(ListItem holder, int position) {
        holder.populate(keyList[position], mItemsHashMap.get(keyList[position]));
        holder.setListItemInterface(mItemInterface);

    }

    private ListItem.ListItemInterface mItemInterface = new ListItem.ListItemInterface() {
        @Override
        public void onItemClicked(ArrayList<Item> items) {
            if (mListAdapterInterface != null) {
                mListAdapterInterface.onItemClicked(items);
            }
        }
    };

    public void setListAdapterInterface(ListAdapterInterface listAdapterInterface) {
        this.mListAdapterInterface = listAdapterInterface;
    }

    public interface ListAdapterInterface {
        void onItemClicked(ArrayList<Item> items);
    }

}
