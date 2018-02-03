package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.presenter.VideoPresenter;
import com.bwie.d.quarterhour.view.IView.VideoViewCallBack;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity implements VideoViewCallBack {

    @BindView(R.id.video_out)
    ImageView videoOut;
    @BindView(R.id.video_xin)
    ImageView videoXin;
    @BindView(R.id.video_bankexin)
    ImageView videoBankexin;
    @BindView(R.id.video_zhuanfa)
    ImageView videoZhuanfa;
    @BindView(R.id.vieo_touxiang)
    SimpleDraweeView vieoTouxiang;
    @BindView(R.id.video_name)
    TextView videoName;
    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard videoplayer;

    private int position;
    private VideoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        videoOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VideoActivity.this,"返回",Toast.LENGTH_SHORT).show();
            }
        });

        presenter = new VideoPresenter(this);
        presenter.getDataVideo();

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 1);
        Log.i("--------position=====", position + "");
    }

    @Override
    public void getSuccess(VideoBean bean) {
        List<VideoBean.DataBean> list = bean.getData();
        Log.i("------------list=====", list.toString());
        String videoUrl = list.get(position).getVideoUrl();
        String path = "https://www.zhaoapi.cn//images//quarter//1517214006706VID_20180129_161934.mp4";
        System.out.print("================" + list.get(position).getVideoUrl());
        videoplayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, list.get(position).getUser().getNickname());

        videoName.setText(list.get(position).getUser().getNickname());
    }

    @Override
    public void getFailure(Exception e) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
