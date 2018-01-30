package com.bwie.d.quarterhour.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;

/**
 * Created by weicy on 2018/1/20.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * fresco图片加载框架初始化
         */
        Fresco.initialize(this);
        /**
         * mob分享初始化
         */
        MobSDK.init(this);
    }
}
