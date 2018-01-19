package com.bwie.d.quarterhour.view.activity;

import android.os.Bundle;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

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
