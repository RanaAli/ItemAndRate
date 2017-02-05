package com.ranaali.itemandrate.itemListScreen;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.ranaali.itemandrate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class MainScreenView {
    private View mView;

    @BindView(R.id.mainListRecycleView)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.mainScreenProgressRelativeLayout)
    protected RelativeLayout mProgressLayout;

    private LinearLayoutManager mLinearLayoutManager;

    MainScreenView(View mView) {
        this.mView = mView;

        ButterKnife.bind(this, mView);

        setupView();
    }

    private void setupView() {
        mLinearLayoutManager = new LinearLayoutManager(mView.getContext());

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

    }

    public void populateList(ItemListAdaptor listAdaptor) {
        mRecyclerView.setAdapter(listAdaptor);
    }

    public Context getContext() {
        return mView.getContext();
    }

    public void showProgress() {
        mProgressLayout.setVisibility(View.VISIBLE);
    }

    public void dismissProgress() {
        mProgressLayout.setVisibility(View.GONE);
    }

}
