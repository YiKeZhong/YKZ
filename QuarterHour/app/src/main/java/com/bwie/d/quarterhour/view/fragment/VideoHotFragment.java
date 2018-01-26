package com.bwie.d.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.VideoBean;
import com.bwie.d.quarterhour.presenter.VideoPresenter;
import com.bwie.d.quarterhour.view.IView.VideoViewCallBack;
import com.bwie.d.quarterhour.view.adapter.VideoRecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;

/**
 * Created by 张继业 on 2018/1/26.
 */

public class VideoHotFragment extends Fragment implements VideoViewCallBack {

    @BindView(R.id.recicler_hot)
    RecyclerView reciclerHot;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_video, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        VideoPresenter presenter = new VideoPresenter(this);
        presenter.getDataVideo();
    }

    @Override
    public void getSuccess(VideoBean bean) {
        List<VideoBean.DataBean> list = bean.getData();
        reciclerHot.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        //reciclerVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
        VideoRecyclerViewAdapter adapter = new VideoRecyclerViewAdapter(getActivity(), list);
        reciclerHot.setAdapter(adapter);
    }

    @Override
    public void getFailure(Exception e) {

    }

    @Override
    public void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
