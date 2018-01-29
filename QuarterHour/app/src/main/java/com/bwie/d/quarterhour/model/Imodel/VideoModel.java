package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.utils.IGetDataBase;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoModel {

    //https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=101&page=10&token=10
    public void getVideoData(final VideoModelCallBack callBack){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//token=、source=android、appVersion=101
        HashMap<String, String> map = new HashMap<>();
        map.put("token","10");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","1");
        IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);
        Call<VideoBean> call = iGetDataBase.getVideoData(map);
        call.enqueue(new Callback<VideoBean>() {
            @Override
            public void onResponse(Call<VideoBean> call, Response<VideoBean> response) {
                VideoBean body = response.body();
                callBack.getSuccess(body);
            }

            @Override
            public void onFailure(Call<VideoBean> call, Throwable t) {
                callBack.getFailure(new Exception());
            }
        });
        
    }

    public void getNearbyVideo(){

    }
    public interface VideoModelCallBack{
        public void getSuccess(VideoBean bean);
        public void getFailure(Exception e);
    }
}
