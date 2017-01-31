package com.ranaali.itemandrate;

import android.os.Bundle;

import com.ranaali.itemandrate.applicationbase.BaseActivity;
import com.ranaali.itemandrate.itemListScreen.MainScreenFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();
        addFragment(new MainScreenFragment(), savedInstanceState);
    }
}
