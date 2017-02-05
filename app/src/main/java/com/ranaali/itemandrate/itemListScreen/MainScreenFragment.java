package com.ranaali.itemandrate.itemListScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranaali.itemandrate.R;
import com.ranaali.itemandrate.applicationbase.BaseFragment;

import java.util.ArrayList;

import models.Item;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class MainScreenFragment extends BaseFragment {

    private MainScreenPresenter mMainScreenPresenter;

    private MainScreenFragmentInterface mMainScreenFragmentInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.main_fragment_layout, container, false);

        MainScreenView mainScreenView = new MainScreenView(view);
        mMainScreenPresenter = new MainScreenPresenter(mainScreenView);
        mMainScreenPresenter.setMainScreenPresenterInterface(mainScreenPresenterInterface);

        return view;
    }

    private MainScreenPresenter.MainScreenPresenterInterface
            mainScreenPresenterInterface = new MainScreenPresenter.MainScreenPresenterInterface() {
        @Override
        public void onItemClicked(ArrayList<Item> items) {
            if (mMainScreenFragmentInterface != null) {
                mMainScreenFragmentInterface.showItemDetails(items);
            }
        }
    };

    public void setMainScreenPresenterInterface(MainScreenFragmentInterface mainScreenFragmentInterface) {
        mMainScreenFragmentInterface = mainScreenFragmentInterface;
    }

    public interface MainScreenFragmentInterface {
        void showItemDetails(ArrayList<Item> items);
    }
}
