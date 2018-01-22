package com.bwie.d.quarterhour.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.CrossTalkBean;
import com.bwie.d.quarterhour.view.IView.CrossTalkCallBack;


/**
 * Created by weicy on 2018/1/20.
 */

public class CrossTalkFragment extends Fragment implements CrossTalkCallBack {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crosstalkfragment, container, false);
//https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=101&page=10
        //路径
        recyclerView = view.findViewById(R.id.crossTalk_recycle);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void success(CrossTalkBean crossTalkBean) {

    }
}
