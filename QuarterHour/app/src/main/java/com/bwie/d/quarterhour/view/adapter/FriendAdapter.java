package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.FriendBean;
import com.bwie.d.quarterhour.view.activity.FriendActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by weicy on 2018/2/4.
 */

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder1>{
    Context context;
    List<FriendBean.DataBean> list;
    public FriendAdapter(Context context, List<FriendBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public FriendAdapter.ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.friendlayout, null);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(FriendAdapter.ViewHolder1 holder, int position) {
        String icon = list.get(position).getIcon();
        holder.friend_tupian.setImageURI(icon);
        holder.friend_xaingming.setText(list.get(position).getNickname());
        holder.friend_qianming.setText(list.get(position).getNickname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final SimpleDraweeView friend_tupian;
        private final TextView friend_xaingming;
        private final TextView friend_qianming;

        public ViewHolder1(View itemView) {
            super(itemView);
            friend_tupian = itemView.findViewById(R.id.friend_tupian);
            friend_xaingming = itemView.findViewById(R.id.friend_xaingming);
            friend_qianming = itemView.findViewById(R.id.friend_qianming);
        }
    }
}
