package com.bwie.d.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        initView();
        initData();
    }
    abstract void initView();
    abstract void initData();
    abstract int setContentViewId();





}
