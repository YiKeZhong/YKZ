package com.bwie.d.quarterhour.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.view.adapter.FunnyRecyAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by weicy on 2018/1/22.
 */

public class Funnyfragment extends Fragment {
    @BindView(R.id.funny_recyclerview)
    RecyclerView funnyRecyclerview;
    Unbinder unbinder;
    @BindView(R.id.funny_springview)
    SpringView funnySpringview;
    private FunnyRecyAdapter funnyRecyAdapter;
    private List<String> list;
    private List<String> loadList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.funnyfragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        //recyclerview管理者/分割线/适配器
        initView();
        initData();
        SpringView();
        return view;
    }

    private void initView() {
        funnyRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        funnyRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        funnyRecyAdapter = new FunnyRecyAdapter(getActivity());
        funnyRecyclerview.setAdapter(funnyRecyAdapter);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("趣图无数据" + i);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //将数据添加到适配器---并刷新适配器
        funnyRecyAdapter.addData(list);
        funnyRecyAdapter.notifyDataSetChanged();
    }

    private void SpringView() {
        //上拉加载---下拉刷新
        funnySpringview.setHeader(new DefaultHeader(getActivity()));
        funnySpringview.setFooter(new DefaultFooter(getActivity()));
        funnySpringview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        funnySpringview.onFinishFreshAndLoad();
                    }
                },1000);
            }

            @Override
            public void onLoadmore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        funnySpringview.onFinishFreshAndLoad();
                    }
                },1000);
                loadList = new ArrayList<>();
                for(int i=1;i< 4;i++){
                    loadList.add("刷新"+i);
                }
                funnyRecyAdapter.loadData(loadList);
                funnyRecyAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
