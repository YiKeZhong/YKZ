package com.bwie.d.quarterhour.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.presenter.BasePresenter;

/**
 * Created by d on 2018/1/19.
 */

public abstract class BaseFragment<V,T extends BasePresenter<V>> extends Fragment {

    public abstract T initPresenter();
    public T presenter;
    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = initPresenter();
        context = getContext();
        return null;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
