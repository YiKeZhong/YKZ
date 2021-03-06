package com.bwie.d.quarterhour.presenter;

import com.bwie.d.quarterhour.model.Imodel.CrossTalkModel;
import com.bwie.d.quarterhour.model.bean.CrossTalkBean;
import com.bwie.d.quarterhour.view.IView.CrossTalkCallBack;

/**
 * Created by d on 2018/1/22.
 */

public class CrossTalkPresenter {
    CrossTalkCallBack callBack;
    private final CrossTalkModel talkModel;

    public CrossTalkPresenter(CrossTalkCallBack callBack){
        this.callBack = callBack;
        talkModel = new CrossTalkModel();
    }
    public void CroTalkpresenterget(){
        talkModel.CrossTalkModelget(new CrossTalkModel.CrossTalkModelCallback() {
            @Override
            public void success(CrossTalkBean crossTalkBean) {
                callBack.success(crossTalkBean);
            }
        });
    }
}
