package com.bwie.d.quarterhour.model.retrofit;

import com.bwie.d.quarterhour.view.IView.APIService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by d on 2018/1/19.
 */

public class RetrofitUtils {
    //https://www.zhaoapi.cn
    private static APIService service = null;
    public static APIService getInstance(){
        if(service ==null){
            synchronized (RetrofitUtils.class){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.zhaoapi.cn")
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(OkHttpUtils.getInstance())
                        .build();

                service = retrofit.create(APIService.class);
            }
        }
        return service;
    }
}
