package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.VideoBean;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;
    List<VideoBean.DataBean> list;
    //定义宽度
    private int itemWidth;

    public VideoRecyclerViewAdapter(Context context, List<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;

        //设置宽度
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        itemWidth = width / 2;//定义固定的宽度
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycler_video, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        //设置高
        ViewGroup.LayoutParams params = holder1.ijkplayer.getLayoutParams();

        //初始高度300
        int itemHeight = 300;

        itemHeight = new Random().nextInt(500);
        if (itemHeight < 300) {
            itemHeight = 300;
        }

        //给imageview设置宽高
         params.width = itemWidth;
         params.height = itemHeight;

         holder1.ijkplayer.setLayoutParams(params);

        String videoUrl = list.get(position).getVideoUrl();
        holder1.ijkplayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, list.get(position).getUser().getNickname());
        Glide.with(context).load(list.get(position).getUser().getIcon()).into(holder1.ijkplayer.thumbImageView);
        Log.i("--------","==="+videoUrl+"-------------");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.ijkplayer)
        JZVideoPlayerStandard ijkplayer;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
