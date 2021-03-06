package com.bwie.d.quarterhour.utils;

import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.model.bean.VideoNearBean;

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

    @GET("/quarter/getHotVideos")
    Call<VideoBean> getVideoData(@QueryMap Map<String,String> map);

    //https://www.zhaoapi.cn/quarter/getNearVideos?page=1&latitude=37.422006&longitude=-122.084095&token=10&source=android&appVersion=101
    @GET("/quarter/getNearVideos")
    Call<VideoNearBean> getNearbyData(@QueryMap Map<String,String> map);
}
