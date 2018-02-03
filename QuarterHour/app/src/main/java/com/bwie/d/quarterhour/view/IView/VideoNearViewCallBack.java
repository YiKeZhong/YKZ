package com.bwie.d.quarterhour.view.IView;

import com.bwie.d.quarterhour.model.bean.VideoNearBean;

/**
 * Created by 张继业 on 2018/1/31.
 */

public interface VideoNearViewCallBack {
    public void getSuccess(VideoNearBean bean);
    public void getFailure(Exception e);
}
