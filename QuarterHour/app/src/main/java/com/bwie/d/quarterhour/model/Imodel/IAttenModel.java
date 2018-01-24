package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.model.bean.AttenTJBean;

import io.reactivex.disposables.Disposable;

/**
 * Created by ztz on 2018/1/23.
 */

public interface IAttenModel {
    void Successful(AttenTJBean attenTJBean);
    void Failed(Disposable d);
}
