package com.bwie.d.quarterhour.utils;

import com.bwie.d.quarterhour.model.bean.HotBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weicy on 2018/1/24.
 */

public interface IGetDataBase {
    /**
     * get 请求
     * @param key
     * @return
     */
    @GET("/quarter/getAd")
    Call<HotBean> get();
}
