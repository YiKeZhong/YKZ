package com.bwie.d.quarterhour.view.IView;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by d on 2018/1/19.
 */

public interface APIService {
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String,String> map);
}
