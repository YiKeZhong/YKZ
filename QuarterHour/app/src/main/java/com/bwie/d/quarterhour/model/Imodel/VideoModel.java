package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.model.bean.VideoNearBean;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;
import com.bwie.d.quarterhour.model.retrofit.RetrofitUtils;
import com.bwie.d.quarterhour.utils.IGetDataBase;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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
//    //https://www.zhaoapi.cn/quarter/getNearVideos?page=1&latitude=37.422006&longitude=-122.084095&token=10&source=android&appVersion=101

    public void getNearbyVideo(final VideoNearModelCallBack callBack, String latitude, String longitude){

        HashMap<String, String> map = new HashMap<>();
        map.put("token","10");
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","1");
        map.put("latitude",latitude);
        map.put("longitude",longitude);
        RetrofitUtils.getInstance().get("https://www.zhaoapi.cn",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<VideoNearBean>() {
                    @Override
                    public void success(VideoNearBean videoNearBean) {
                        callBack.getSuccess(videoNearBean);
                    }

                    @Override
                    public void onfailure(Disposable d) {
                        callBack.getFailure(new Exception());
                    }
                });
    }
    public interface VideoModelCallBack{
        public void getSuccess(VideoBean bean);
        public void getFailure(Exception e);
    }
    public interface VideoNearModelCallBack{
        public void getSuccess(VideoNearBean bean);
        public void getFailure(Exception e);
    }
}
