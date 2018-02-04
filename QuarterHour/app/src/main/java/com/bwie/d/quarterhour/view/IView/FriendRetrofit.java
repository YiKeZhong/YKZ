package com.bwie.d.quarterhour.view.IView;

import com.bwie.d.quarterhour.model.bean.FriendBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by weicy on 2018/2/4.
 */

public interface FriendRetrofit {
    @GET("/quarter/searchFriends?source=android&appVersion=101")
    Call<FriendBean> get( @Query("keywords") String keywords);
}
