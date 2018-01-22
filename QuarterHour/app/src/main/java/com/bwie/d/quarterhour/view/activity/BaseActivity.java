package com.bwie.d.quarterhour.view.activity;

import android.app.Activity;
import android.os.Bundle;

import com.bwie.d.quarterhour.presenter.BasePresenter;

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity {

    public T t;
    public abstract T initPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        initView();
        initData();

        t = initPresenter();
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        t.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.detach();
    }*/

    abstract void initView();
    abstract void initData();
    abstract int setContentViewId();





}
