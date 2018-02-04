package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.AttentionBean;
import com.bwie.d.quarterhour.view.activity.AttentionActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by weicy on 2018/2/4.
 */

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.ViewHolder1> {
    Context context;
    List<AttentionBean.DataBean> list;
    public AttentionAdapter(Context context, List<AttentionBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public AttentionAdapter.ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.attentionlayout,null);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(AttentionAdapter.ViewHolder1 holder, int position) {
        String icon = list.get(position).getIcon();
        holder.att_tupian.setImageURI(icon);
        holder.att_shijian.setText(list.get(position).getCreatetime());
        holder.att_xaingming.setText(list.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView att_tupian;
        private final TextView att_xaingming;
        private final TextView att_shijian;

        public ViewHolder1(View itemView) {
            super(itemView);
            att_tupian = itemView.findViewById(R.id.att_tupian);
            att_xaingming = itemView.findViewById(R.id.att_xaingming);
            att_shijian = itemView.findViewById(R.id.att_shijian);
        }
    }
}
