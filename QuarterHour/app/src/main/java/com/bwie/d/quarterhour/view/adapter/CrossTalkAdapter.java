package com.bwie.d.quarterhour.view.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.model.bean.CrossTalkBean;

import java.util.List;

/**
 * Created by d on 2018/1/23.
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.IViewHolder>{

    List<CrossTalkBean.DataBean> data;
    FragmentActivity activity;
    public CrossTalkAdapter(List<CrossTalkBean.DataBean> data, FragmentActivity activity) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class IViewHolder extends RecyclerView.ViewHolder{

        public IViewHolder(View itemView) {
            super(itemView);
        }
    }

}
