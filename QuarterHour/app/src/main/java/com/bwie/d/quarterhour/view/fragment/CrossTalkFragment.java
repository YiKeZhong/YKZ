package com.bwie.d.quarterhour.view.fragment;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.CrossTalkBean;
import com.bwie.d.quarterhour.presenter.CrossTalkPresenter;
import com.bwie.d.quarterhour.view.IView.CrossTalkCallBack;
import com.bwie.d.quarterhour.view.adapter.CrossTalkAdapter;
import com.bwie.d.quarterhour.view.adapter.HotAdapter;
import com.zyao89.view.zloading.ZLoadingView;
import com.zyao89.view.zloading.Z_TYPE;


/**
 * Created by weicy on 2018/1/20.
 */

public class CrossTalkFragment extends Fragment implements CrossTalkCallBack{
    private ImageView image;
    private RecyclerView recyclerView;
    private CrossTalkPresenter presenter;
    private CrossTalkAdapter talkAdapter;
    private LinearLayoutManager manager;
    private PopupWindow mPopWindow;
    private TextView atten_loadingtv1;
    private ZLoadingView attentj_loading1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.crosstalkfragment, container, false);
//https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=101&page=10
        //路径
        recyclerView = view.findViewById(R.id.crossTalk_recycle);
        //设置数据未加载出的动画
        atten_loadingtv1 = view.findViewById(R.id.atten_loadingtv1);
        attentj_loading1 = view.findViewById(R.id.attentj_loading1);
        attentj_loading1.setLoadingBuilder(Z_TYPE.INTERTWINE);//设置类型
        attentj_loading1.setColorFilter(Color.BLUE);//设置颜色
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        presenter = new CrossTalkPresenter(this);
        presenter.CroTalkpresenterget();
    }

    @Override
    public void success(CrossTalkBean crossTalkBean) {

        talkAdapter = new CrossTalkAdapter(crossTalkBean.getData(),getActivity());
        manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(talkAdapter);
        talkAdapter.notifyDataSetChanged();
        //数据加载成功时,进行隐藏动画
        attentj_loading1.setVisibility(View.GONE);
        atten_loadingtv1.setVisibility(View.GONE);
        talkAdapter.setOnItemClickListener(new HotAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                image = view.findViewById(R.id.d_image);
                image.setImageResource(R.drawable.breduce);
                //弹框
                showPopupWindow(view);
            }
            private void showPopupWindow(final View vvv) {
                View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.photo_popup_layout, null);
                mPopWindow = new PopupWindow(contentView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                mPopWindow.setContentView(contentView);
                mPopWindow.setBackgroundDrawable(new BitmapDrawable());
                mPopWindow.setOutsideTouchable(true);
                mPopWindow.setAnimationStyle(R.style.AnimationPreview);
                ColorDrawable dw = new ColorDrawable(0000000000);
                mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        ImageView image = vvv.findViewById(R.id.d_image);

                        image.setImageResource(R.drawable.badd);
                    }
                });

                contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                int  mShowMorePopupWindowWidth = -contentView.getMeasuredWidth();
                int  mShowMorePopupWindowHeight = -contentView.getMeasuredHeight();
                mPopWindow.showAsDropDown(vvv,mShowMorePopupWindowWidth, mShowMorePopupWindowHeight);

            }
        });
    }




}
