package com.bwie.d.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.view.adapter.AttenRecyAdapter;
import com.bwie.d.quarterhour.view.adapter.FunnyRecyAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by weicy on 2018/1/22.
 */

public class HotFragment extends Fragment {
    private SpringView Spr;
    private RecyclerView recyclerView;
    private TextView text_01;
    private String string;
    private View view;
    private AttenRecyAdapter attenRecyAdapter;
    private RecyclerView attRecyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        string = bundle.getString("name", "全部");
        Log.e("onCreateViewstring: ", string + "123123");
        if (string == "全部") {
            view = inflater.inflate(R.layout.hotfragment, container, false);
            recyclerView = view.findViewById(R.id.recy);
            Spr = view.findViewById(R.id.Spr);
            //数据请求


            Spr.setHeader(new DefaultHeader(getActivity()));
            Spr.setFooter(new DefaultFooter(getActivity()));
            Spr.setListener(new SpringView.OnFreshListener() {
                @Override
                public void onRefresh() {
                    //下拉刷新
                    Spr.onFinishFreshAndLoad();
                }

                @Override
                public void onLoadmore() {
                    //上拉加载
                    Spr.onFinishFreshAndLoad();
                }
            });

            /**
             * 关注页面
             */
        } else if (string == "关注") {
            view = inflater.inflate(R.layout.attentionfragment, container, false);
            attRecyclerview = view.findViewById(R.id.att_recyclerview);
            //recyclerview管理者/分割线/适配器
            attRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            attRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
            attenRecyAdapter = new AttenRecyAdapter(getActivity());
            attRecyclerview.setAdapter(attenRecyAdapter);
        }

        return view;
    }

}
