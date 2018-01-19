package com.bwie.d.quarterhour.presenter;

/**
 * Created by d on 2018/1/19.
 */

public class BasePresenter<V>{

    public V view;

    public void attach(V v){
        this.view = v;
    }

    public void detach(){
        this.view = null;
    }
}
