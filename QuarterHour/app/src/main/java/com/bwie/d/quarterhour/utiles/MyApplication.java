package com.bwie.d.quarterhour.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by weicy on 2018/1/20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
