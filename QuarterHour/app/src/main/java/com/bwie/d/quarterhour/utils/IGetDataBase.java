package com.bwie.d.quarterhour.utils;

import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.model.bean.VideoBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by weicy on 2018/1/24.
 */

public interface IGetDataBase {
    /**
     * get 请求
     * @param key
     * @return
     */
    @GET("/quarter/getVideos?type=1&page=1&source=android&appVersion=101")
    Call<HotBean> get();

    @GET("/quarter/getNearVideos")
    Call<VideoBean> getVideoData(@QueryMap Map<String,String> map);
}
