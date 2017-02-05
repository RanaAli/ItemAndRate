package com.ranaali.itemandrate.itemdetails;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ranaali.itemandrate.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class ItemDetailsView {
    private View mView;

    @BindView(R.id.detailsListRecycleView)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.detailsProgressRelativeLayout)
    protected RelativeLayout mProgressLayout;

    @BindView(R.id.detailsListTotalTextView)
    protected TextView detailsListTotalTextView;

    private LinearLayoutManager mLinearLayoutManager;

    public ItemDetailsView(View mView) {
        this.mView = mView;

        ButterKnife.bind(this, mView);

        setupView();
    }

    private void setupView() {
        mLinearLayoutManager = new LinearLayoutManager(mView.getContext());

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

    }

    public void populateList(ItemDetailAdaptor itemDetailAdaptor) {
        mRecyclerView.setAdapter(itemDetailAdaptor);
    }

    public void setTotalAmount(String totalAmount){
        detailsListTotalTextView.setText(totalAmount);
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
