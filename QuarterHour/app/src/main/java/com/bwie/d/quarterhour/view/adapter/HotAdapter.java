package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.view.Web.HotWebViewActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weicy on 2018/1/24.
 */

public class HotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //放图片地址的集合
    ArrayList<String> list_path = new ArrayList<>();
    //放标题的集合
    ArrayList<String> list_title = new ArrayList<>();
    Context context;
    List<HotBean.DataBean> list;
    public HotAdapter(Context context, List<HotBean.DataBean> list) {
        this.context=context;
        this.list=list;

    }

    @Override
    public int getItemViewType(int position) {

        return position==0?0:1;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotadapter, null);

            return new ViewHolder1(view);

        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e( "onResp123onse12312: ", list.get(0).getTitle() );
        if (holder instanceof ViewHolder1){
            for (int i=0 ; i<4; i++){
                list_path.add(list.get(i).getIcon());
                list_title.add(list.get(i).getTitle());
            }
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
                        String url = list.get(position).getUrl();
                        intent.putExtra("name",""+url);
                    }else if (position==1){
                        String url = list.get(position).getUrl();
                        intent.putExtra("name",""+url);
                    }else if (position==2){
                        String url = list.get(position).getUrl();
                        intent.putExtra("name",""+url);
                    }else if (position==3){
                        String url = list.get(position).getUrl();
                        intent.putExtra("name",""+url);
                    }


                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner banner;


         ViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);

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
