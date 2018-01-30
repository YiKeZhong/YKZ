package com.bwie.d.quarterhour.view.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class VideoActivity extends BaseActivity {


    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {

    }

    @Override
    void initData() {

    }

    @Override
    int setContentViewId() {
        return R.layout.activity_video;
    }
}
