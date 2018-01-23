package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2018/1/23.
 */

public class AttenRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_IMAGE = 0;
    private final static int TYPE_Line = 1;

    private Context context;
    private View view;

    public AttenRecyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {//第一个条目展示图片

            return TYPE_IMAGE;
        } else {//其他条目展示关注的列表

            return TYPE_Line;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_IMAGE) {
            view = LayoutInflater.from(context).inflate(R.layout.item_tjattenimg_layout, parent, false);
            return new imgViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_tjattenline_layout, parent, false);
            return new lineViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String img_url = "https://v2.modao.cc/uploads3/images/1103/11038871/raw_1500002643.png";
        if (holder instanceof imgViewHolder){
            ((imgViewHolder) holder).tjAttensimpleDrawee.setImageURI(img_url);
        }else if (holder instanceof  lineViewHolder){
            ((lineViewHolder) holder).textTest.setText("推荐——关注");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static class imgViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tj_attensimpleDrawee)
        SimpleDraweeView tjAttensimpleDrawee;

        imgViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class lineViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_test)
        TextView textTest;

        lineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
