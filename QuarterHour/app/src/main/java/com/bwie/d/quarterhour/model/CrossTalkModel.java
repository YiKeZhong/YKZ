package com.bwie.d.quarterhour.model;

import com.bwie.d.quarterhour.model.bean.CrossTalkBean;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;
import com.bwie.d.quarterhour.model.retrofit.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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
        RetrofitUtils.getInstance().get("/quarter/getJokes",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<CrossTalkBean>() {
                    @Override
                    public void success(CrossTalkBean crossTalkBean) {
                        System.out.println("liqiwen"+crossTalkBean.toString());
                        modelCallback.success(crossTalkBean);
                    }

                    @Override
                    public void onfailure(Disposable d) {
                        System.out.println("1111111111111111");
                    }
                });
    }
    /*APIFactory.getInstance().get("/quarter/getJokes", map, new AbstractObserver<CrossTalkBean>() {
               @Override
               public void success(CrossTalkBean crossTalkBean) {
                   System.out.println("liqiwen"+crossTalkBean.toString());
                   modelCallback.success(crossTalkBean);
               }

               @Override
               public void onfailure(Disposable d) {
                   System.out.println("1111111111111111");
               }
           });*/
    public interface CrossTalkModelCallback{
        public void success(CrossTalkBean crossTalkBean);
    }
}
