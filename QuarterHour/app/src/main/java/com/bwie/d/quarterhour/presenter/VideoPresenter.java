package com.bwie.d.quarterhour.presenter;


import com.bwie.d.quarterhour.model.Imodel.VideoModel;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.view.IView.VideoViewCallBack;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoPresenter extends BasePresenter<VideoViewCallBack> {

    VideoViewCallBack viewCallBack;
    VideoModel videoModel;

    public VideoPresenter(VideoViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
        videoModel = new VideoModel();
    }

    public void getDataVideo(){
        videoModel.getVideoData(new VideoModel.VideoModelCallBack() {
            @Override
            public void getSuccess(VideoBean bean) {
                viewCallBack.getSuccess(bean);
            }

            @Override
            public void getFailure(Exception e) {
                viewCallBack.getFailure(e);
            }
        });
    }

    public void detachView() {//解除关联
        if (videoModel != null) {
            videoModel = null;
        }
    }
}
