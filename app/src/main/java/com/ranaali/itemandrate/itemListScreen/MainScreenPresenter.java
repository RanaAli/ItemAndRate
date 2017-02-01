package com.ranaali.itemandrate.itemListScreen;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.HashMap;

import models.Item;
import utils.TransactionIO;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class MainScreenPresenter {

    private MainScreenView mMainScreenView;

    private MainScreenPresenterInterface mMainScreenPresenterInterface;

    public MainScreenPresenter(MainScreenView mMainScreenView) {
        this.mMainScreenView = mMainScreenView;

        new PrepareDataTask().execute();
    }

    private class PrepareDataTask extends AsyncTask<Void, Void, HashMap<String, ArrayList<Item>>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            mMainScreenView.showProgress();
        }

        @Override
        protected HashMap<String, ArrayList<Item>> doInBackground(Void... voidss) {
            return TransactionIO.prepareData(mMainScreenView.getContext());
        }

        @Override
        protected void onPostExecute(HashMap<String, ArrayList<Item>> stringArrayListHashMap) {
            super.onPostExecute(stringArrayListHashMap);

            if (stringArrayListHashMap != null) {
                ItemListAdaptor itemListAdaptor = new ItemListAdaptor(stringArrayListHashMap);
                itemListAdaptor.setListAdapterInterface(listAdapterInterface);

                mMainScreenView.populateList(itemListAdaptor);

            }

            mMainScreenView.dismissProgress();

        }
    }

    private ItemListAdaptor.ListAdapterInterface
            listAdapterInterface = new ItemListAdaptor.ListAdapterInterface() {
        @Override
        public void onItemClicked(ArrayList<Item> items) {
            if (mMainScreenPresenterInterface != null) {
                mMainScreenPresenterInterface.onItemClicked(items);
            }
        }
    };

    public void setMainScreenPresenterInterface(
            MainScreenPresenterInterface mainScreenPresenterInterface) {
        mMainScreenPresenterInterface = mainScreenPresenterInterface;
    }

    public interface MainScreenPresenterInterface {
        void onItemClicked(ArrayList<Item> items);
    }

}
