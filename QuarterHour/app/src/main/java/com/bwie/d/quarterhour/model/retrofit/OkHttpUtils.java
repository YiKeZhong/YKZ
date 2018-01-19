package com.bwie.d.quarterhour.model.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by d on 2018/1/19.
 */

public class OkHttpUtils {

    private static OkHttpClient client =null;

    public static OkHttpClient getInstance(){
        if(client==null){
            synchronized (OkHttpUtils.class){
                if(client==null){
                    if(client==null){
                        client = new OkHttpClient.Builder()
                                .writeTimeout(20000, TimeUnit.SECONDS)
                                .connectTimeout(20000, TimeUnit.SECONDS)
                                .readTimeout(20000, TimeUnit.SECONDS)
                                .build();
                    }
                }
            }
        }
        return client;
    }
}
