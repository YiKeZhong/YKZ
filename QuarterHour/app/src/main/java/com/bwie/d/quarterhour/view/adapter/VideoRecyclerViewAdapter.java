package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 张继业 on 2018/1/23.
 */

public class VideoRecyclerViewAdapter extends RecyclerView.Adapter {
    Context context;
    List<VideoBean.DataBean> list;
    private ArrayList<Integer> mHeights;
    //定义宽度
    private int itemWidth;

    public VideoRecyclerViewAdapter(Context context, List<VideoBean.DataBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recycler_video, null);
        return new ViewHolder(view);
    }

    public void getRandomHight(){
        mHeights = new ArrayList<>();
        for(int i=0; i < list.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        getRandomHight();
        ViewGroup.LayoutParams layoutParams = holder1.videoImage.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder1.videoImage.setLayoutParams(layoutParams);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null){
                    onItemClickListener.onClick(position);
                }
            }
        });
        Glide.with(context).load(list.get(position).getUser().getIcon()).into(holder1.videoImage);
//        String videoUrl = list.get(position).getVideoUrl();
//        holder1.ijkplayer.setUp(videoUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, list.get(position).getUser().getNickname());
//        Glide.with(context).load(list.get(position).getUser().getIcon()).into(holder1.ijkplayer.thumbImageView);
//        Log.i("--------","==="+videoUrl+"-------------");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.video_image)
        ImageView videoImage;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /**
     * 点击
     */
    public interface OnItemClickListener {
        void onClick(int position);
    }

    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
