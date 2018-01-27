package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.view.Web.HotWebViewActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by weicy on 2018/1/24.
 */

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //放图片地址的集合
    ArrayList<String> list_path = new ArrayList<>();
    //放标题的集合
    ArrayList<String> list_title = new ArrayList<>();
    //url地址
    ArrayList<String> list_url = new ArrayList<>();
    private final static int TYPE_IMAGE = 0;
    private final static int TYPE_Line = 1;


    Context context;
    List<HotBean.DataBean> list;
    public HotAdapter(Context context, List<HotBean.DataBean> list) {
        this.context=context;
        this.list=list;
        Log.i("weicy1w",list.get(0).getCover());
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

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotadapter, null);

            return new ViewHolder1(view);

        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.item_hot_layout, parent, false);
            return new lineViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        list_path.add("https://www.zhaoapi.cn/images/quarter/ad1.png");
        list_path.add("https://www.zhaoapi.cn/images/quarter/ad2.png");
        list_path.add("https://www.zhaoapi.cn/images/quarter/ad3.png");
        list_path.add("https://www.zhaoapi.cn/images/quarter/ad4.png");
        list_title.add("第十三界瑞丽模特大赛");
        list_title.add("文化艺术节");
        list_title.add("直播封面标准");
        list_title.add("人气谁最高，金主谁最豪气");
        list_url.add("http://m.mv14449315.icoc.bz/index.jsp");
        list_url.add("http://m.mv14449315.icoc.bz/index.jsp");
        list_url.add("http://m.mv14449315.icoc.bz/index.jsp");
        list_url.add("http://m.mv14449315.icoc.bz/index.jsp");
        if (holder instanceof ViewHolder1){

//设置内置样式，共有六种可以点入方法内逐一体验使用。
            ((ViewHolder1) holder).banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            //设置图片加载器，图片加载器在下方
            ((ViewHolder1) holder).banner.setImageLoader(new MyLoader());
            //设置图片网址或地址的集合
            ((ViewHolder1) holder).banner.setImages(list_path);
            //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
            ((ViewHolder1) holder).banner.setBannerAnimation(Transformer.Default);
            //设置轮播图的标题集合
            ((ViewHolder1) holder).banner.setBannerTitles(list_title);
            //设置轮播间隔时间
            ((ViewHolder1) holder).banner.setDelayTime(3000);
            //设置是否为自动轮播，默认是“是”。
            ((ViewHolder1) holder).banner.isAutoPlay(true);
            //设置指示器的位置，小点点，左中右。
            ((ViewHolder1) holder).banner.setIndicatorGravity(BannerConfig.CENTER)
                    //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。

                    //必须最后调用的方法，启动轮播图。
                    .start();
            ((ViewHolder1) holder).banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, HotWebViewActivity.class);
                    if (position==0){
                        String url = list_url.get(position);
                        intent.putExtra("name",""+url);
                    }else if (position==1){
                        String url = list_url.get(position);
                        intent.putExtra("name",""+url);
                    }else if (position==2){
                        String url = list_url.get(position);
                        intent.putExtra("name",""+url);
                    }else if (position==3){
                        String url = list_url.get(position);
                        intent.putExtra("name",""+url);
                    }


                    context.startActivity(intent);
                }
            });
        }else if (holder instanceof lineViewHolder) {
            String user_icon = list.get(position).getUser().getIcon() + "";
            String big_img = list.get(position).getCover();
            String vidoe_url = list.get(position).getVideoUrl();

            ((lineViewHolder) holder).tjAttenTvname.setText(list.get(position).getUser().getNickname() + "");
            ((lineViewHolder) holder).tjAttenTvtime.setText(list.get(position).getCreateTime());
            ((lineViewHolder) holder).tjAttenSimpleDraweeIcon.setImageURI(user_icon);
            ((lineViewHolder) holder).tjAttenTvtheme.setText(list.get(position).getWorkDesc());
            //进行播放视频
            ((lineViewHolder) holder).tjattenvideo.setUp(vidoe_url,JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
            Glide.with(context).load(big_img).into(((lineViewHolder) holder).tjattenvideo.thumbImageView);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner banner;


         ViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

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
        @BindView(R.id.tj_atten_video)
        JZVideoPlayerStandard tjattenvideo;
        lineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }


}
