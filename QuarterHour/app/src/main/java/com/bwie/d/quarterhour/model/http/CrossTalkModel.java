package com.bwie.d.quarterhour.model.http;

import com.bwie.d.quarterhour.model.bean.CrossTalkBean;
import com.bwie.d.quarterhour.model.retrofit.APIFactory;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by d on 2018/1/19.
 */

public class CrossTalkModel {

//Model
//source=android&appVersion=101&page=10
    public void CrossTalkModelget(final CrossTalkModelCallback modelCallback){
        Map<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        map.put("page","10");
        APIFactory.getInstance().get("/quarter/getJokes", map, new AbstractObserver<CrossTalkBean>() {
            @Override
            public void success(CrossTalkBean crossTalkBean) {
                modelCallback.success(crossTalkBean);
            }

            @Override
            public void onfailure(Disposable d) {

            }
        });
    }

    public interface CrossTalkModelCallback{
        public void success(CrossTalkBean crossTalkBean);
    }
}
