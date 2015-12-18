package com.example.leak;

import android.support.v7.app.AppCompatActivity;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by sergeyd on 12/16/15.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = ExampleApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }
}
