package utils;

import android.content.Context;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ranaali.itemandrate.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class TransactionIO {

    public static HashMap<String, ArrayList<Item>> prepareData(Context context) {
        HashMap<String, ArrayList<Item>> keyHashMap = new HashMap<>();

        ArrayList<Item> items = getItemsData(context);

        if(items == null){
            return null;
        }

        for (Item item : items) {
            String sku = item.getSku();

            if (keyHashMap.containsKey(sku)) {

                ArrayList<Item> itemArrayList = keyHashMap.get(sku);
                itemArrayList.add(item);

            } else {

                ArrayList<Item> itemArrayList = new ArrayList<>();
                itemArrayList.add(item);

                keyHashMap.put(sku, itemArrayList);
            }

        }

        return keyHashMap;
    }

    @Nullable
    public static ArrayList<Item> getItemsData(Context context) {
        Gson gson = new Gson();
        return gson.fromJson(FileIO.readFile(context, R.raw.transactions),
                new TypeToken<List<Item>>() {
                }.getType());
    }
}
