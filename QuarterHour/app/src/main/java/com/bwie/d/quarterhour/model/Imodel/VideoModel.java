package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.model.retrofit.APIFactory;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoModel {

    //https://www.zhaoapi.cn/quarter/getHotVideos?source=android&appVersion=101&page=10&token=10
    public void getVideoData(final VideoModelCallBack callBack){
        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("token","10");
        map.put("page","10");
        APIFactory.getInstance().get("/quarter/getHotVideos", map, new AbstractObserver<VideoBean>() {
            @Override
            public void success(VideoBean bean) {
                callBack.getSuccess(bean);
            }

            @Override
            public void onfailure(Disposable d) {
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
