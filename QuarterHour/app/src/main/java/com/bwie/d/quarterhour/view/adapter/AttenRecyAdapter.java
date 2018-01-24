package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.AttenTJBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2018/1/23.
 */

public class AttenRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_IMAGE = 0;
    private final static int TYPE_Line = 1;
    private ArrayList<AttenTJBean.DataBean> list = new ArrayList<>();

    private Context context;
    private View view;

    public AttenRecyAdapter(Context context) {
        this.context = context;
    }

    private List<AttenTJBean.DataBean> data;

    public void addData(List<AttenTJBean.DataBean> data) {
        this.data = data;
        if (data != null) {
            list.addAll(data);
        }
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
        if (holder instanceof imgViewHolder) {
            ((imgViewHolder) holder).tjAttensimpleDrawee.setImageURI(img_url);
        } else if (holder instanceof lineViewHolder) {
            String user_icon = list.get(position).getUser().getIcon()+"";
            String big_img = list.get(position).getCover();
            ((lineViewHolder) holder).tjAttenTvname.setText(list.get(position).getUser().getNickname()+"");
            ((lineViewHolder) holder).tjAttenTvtime.setText(list.get(position).getCreateTime());
            ((lineViewHolder) holder).tjAttenSimpleDraweeIcon.setImageURI(user_icon);
            ((lineViewHolder) holder).tjAttenTvtheme.setText(list.get(position).getWorkDesc());
            ((lineViewHolder) holder).tjattensimplebigimg.setImageURI(big_img);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class imgViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tj_attensimpleDrawee)
        SimpleDraweeView tjAttensimpleDrawee;

        imgViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class lineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tj_atten_simpleDrawee_icon)
        SimpleDraweeView tjAttenSimpleDraweeIcon;
        @BindView(R.id.tj_atten_tvname)
        TextView tjAttenTvname;
        @BindView(R.id.tj_atten_tvtime)
        TextView tjAttenTvtime;
        @BindView(R.id.tj_atten_imgjia)
        ImageView tjAttenImgjia;
        @BindView(R.id.tj_atten_tvtheme)
        TextView tjAttenTvtheme;
        @BindView(R.id.tj_atten_simple_bigimg)
        SimpleDraweeView tjattensimplebigimg;

        lineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
