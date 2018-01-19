package com.bwie.d.quarterhour.model.retrofit;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by d on 2018/1/19.
 */

public abstract class AbstractObserver<T> implements Observer<String> {


    public abstract void success(T t);

    public abstract void onfailure(Disposable d);
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String s) {

        Type type = getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        Class clazz = (Class) types[0];
        Gson gson = new Gson();
        T t = (T) gson.fromJson(s, clazz);

        success(t);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
