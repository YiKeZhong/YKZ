package com.bwie.d.quarterhour.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;


/**
 * Created by weicy on 2018/1/20.
 */

public class VideoFragment extends BaseFragment {
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        return view;
    }
}
