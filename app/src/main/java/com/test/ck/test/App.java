package com.test.ck.test;

import android.app.Application;

import com.example.stateviewlib.View.StateLayout;

/**
 * Created by ck on 2017/7/30.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        StateLayout.init(new StateLayout.Builder()
                .setEmptyRes(R.layout.empty)
                .setErrorRes(R.layout.error)
                .setLoadingRes(R.layout.loading)
                .build()
        );

    }
}
