package com.bwie.d.quarterhour.model.retrofit;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by d on 2018/1/19.
 */

public class APIFactory {
    //单例APIFactory对象   通过这个类.get方法请求网络
    private static APIFactory apiFactory =null;
    public static APIFactory getInstance(){
        if(apiFactory==null){
            synchronized (APIFactory.class){
                if (apiFactory==null){
                    apiFactory = new APIFactory();
                }
            }
        }
        return apiFactory;
    }


    public void get(String url, Map<String,String> map, Observer<String> observer){
        RetrofitUtils.getInstance().get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
