package com.bwie.d.quarterhour.view.IView;

import com.bwie.d.quarterhour.model.bean.AttentionBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weicy on 2018/2/4.
 */

public interface AttentionRetrofit {
    @GET("/quarter/getFollowUsers?token=86FCC9EB8A6142A4197DB74D95B15B67&source=android&appVersion=101&uid=12273")
    Call<AttentionBean> get();
}
