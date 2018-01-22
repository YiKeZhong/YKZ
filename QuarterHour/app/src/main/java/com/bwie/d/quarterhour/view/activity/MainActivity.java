package com.bwie.d.quarterhour.view.activity;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.view.SlideMenu;
import com.bwie.d.quarterhour.view.fragment.CrossTalkFragment;
import com.bwie.d.quarterhour.view.fragment.Funnyfragment;
import com.bwie.d.quarterhour.view.fragment.RecommendFragment;
import com.bwie.d.quarterhour.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initView() {
    //初始化控件
    }

    @Override
    void initData() {
    //初始化数据
    }

    @Override
    int setContentViewId() {
        //指定引用布局
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter initPresenter() {
        //初始化Presenter
        return null;
    }
}
