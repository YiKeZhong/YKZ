package com.bwie.d.quarterhour.view.fragment;

import android.content.Intent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.presenter.VideoPresenter;
import com.bwie.d.quarterhour.view.IView.VideoViewCallBack;
import com.bwie.d.quarterhour.view.activity.VideoActivity;
import com.bwie.d.quarterhour.view.adapter.VideoRecyclerViewAdapter;

import java.util.List;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.presenter.VideoPresenter;
import com.bwie.d.quarterhour.view.IView.VideoViewCallBack;
import com.bwie.d.quarterhour.view.activity.VideoActivity;
import com.bwie.d.quarterhour.view.adapter.VideoRecyclerViewAdapter;
import com.zyao89.view.zloading.ZLoadingView;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 张继业 on 2018/1/26.
 */

public class VideoNearbyFragment extends Fragment implements VideoViewCallBack {
    @BindView(R.id.recycler_nearby)
    RecyclerView recyclerNearby;
public class VideoNearbyFragment  extends Fragment implements VideoViewCallBack {

    @BindView(R.id.recicler_hot)
    RecyclerView reciclerHot;
    Unbinder unbinder;

    private VideoPresenter presenter;

    private ZLoadingView attentj_loading;
    private TextView atten_loadingtv;
    private ImageView image;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_video, null);
        unbinder = ButterKnife.bind(this, view);
        //设置数据未加载出的动画
        atten_loadingtv = view.findViewById(R.id.atten_loadingtv1);
        attentj_loading = view.findViewById(R.id.attentj_loading1);
        attentj_loading.setLoadingBuilder(Z_TYPE.INTERTWINE);//设置类型
        attentj_loading.setColorFilter(Color.BLUE);//设置颜色
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter = new VideoPresenter(this);
        presenter.getDataVideo();
        VideoPresenter presenter = new VideoPresenter(this);
        presenter.getDataVideo();
    }



    @Override
    public void getSuccess(VideoBean bean) {
        final List<VideoBean.DataBean> list = bean.getData();
        if (list != null) {
            reciclerHot.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
            //reciclerVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
            VideoRecyclerViewAdapter adapter = new VideoRecyclerViewAdapter(getActivity(), list);
            reciclerHot.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            //数据加载成功时,进行隐藏动画
            attentj_loading.setVisibility(View.GONE);
            atten_loadingtv.setVisibility(View.GONE);
            adapter.setOnItemClickListener(new VideoRecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {

                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void getFailure(Exception e) {

    }


    @Override
    public void getSuccess(VideoBean bean) {
        final List<VideoBean.DataBean> list = bean.getData();
        if (list != null) {
            recyclerNearby.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
            //reciclerVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
            VideoRecyclerViewAdapter adapter = new VideoRecyclerViewAdapter(getActivity(), list);
            recyclerNearby.setAdapter(adapter);

            adapter.setOnItemClickListener(new VideoRecyclerViewAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {

                    Intent intent = new Intent(getActivity(), VideoActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void getFailure(Exception e) {

    }

}
