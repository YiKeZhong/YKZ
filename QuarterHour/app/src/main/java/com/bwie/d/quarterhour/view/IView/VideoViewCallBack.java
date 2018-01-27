package com.bwie.d.quarterhour.view.IView;

import com.bwie.d.quarterhour.model.bean.VideoBean;

/**
 * Created by 张继业 on 2018/1/23.
 */

public interface VideoViewCallBack {
    public void getSuccess(VideoBean bean);
    public void getFailure(Exception e);
}
