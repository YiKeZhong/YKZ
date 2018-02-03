package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
import cn.sharesdk.onekeyshare.OnekeyShare;

import static com.mob.tools.utils.Strings.getString;

/**
 * Created by weicy on 2018/1/24.
 */

public class CollectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int TYPE_IMAGE = 0;
    private final static int TYPE_Line = 1;
    private boolean ADD=true;
    private boolean Xin=true;
    private boolean Xing=true;

    Context context;
    List<HotBean.DataBean> list;
    public CollectAdapter(Context context, List<HotBean.DataBean> list) {
        this.context=context;
        this.list=list;

    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_hot_layout, parent, false);
            return new lineViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


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
            //图片的点击事件
            ((lineViewHolder) holder).dimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v,position);


                }
            });
            //点亮爱心
            ((lineViewHolder) holder).attentjzan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Toast.makeText(context,"we",Toast.LENGTH_SHORT).show();
                    if (Xin){
                        ((lineViewHolder) holder).attentjzan.setImageResource(R.drawable.hong_xin);
                        ((lineViewHolder) holder).attentj_zannum.setText("1365");
                        Xin=false;
                    }else {
                        ((lineViewHolder) holder).attentjzan.setImageResource(R.drawable.bai_xin);
                        ((lineViewHolder) holder).attentj_zannum.setText("1364");
                        Xin=true;
                    }

                }
            });
            //点亮星星
            ((lineViewHolder) holder).attentj_xing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Xing){
                        ((lineViewHolder) holder).attentj_xing.setImageResource(R.drawable.xingxng_02);
                        ((lineViewHolder) holder).attentj_xingnum.setText("123");
                        Xing=false;
                    }else {
                        ((lineViewHolder) holder).attentj_xing.setImageResource(R.drawable.xingxng_01);
                        ((lineViewHolder) holder).attentj_xingnum.setText("122");
                        Xing=true;
                    }
                }
            });


            //点击进行分享
            ((lineViewHolder) holder).attentjshare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    OnekeyShare oks = new OnekeyShare();
                    //关闭sso授权
                    oks.disableSSOWhenAuthorize();
                    // title标题，微信、QQ和QQ空间等平台使用
                    oks.setTitle(getString(R.string.app_name));
                    // titleUrl QQ和QQ空间跳转链接
                    oks.setTitleUrl("http://www.baidu.com");
                    // text是分享文本，所有平台都需要这个字段
                    oks.setText("我是分享文本");
                    // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                    oks.setImagePath("https://ss0.bdstatic.com/6ONWsjip0QIZ8tyhnq/it/u=1618097094,4154452434&fm=77&w_h=121_75&cs=423647557,799948659");//确保SDcard下面存在此张图片
                    // url在微信、微博，Facebook等平台中使用
                    oks.setUrl("http://www.baidu.com");
                    // comment是我对这条分享的评论，仅在人人网使用
                    //oks.setComment("我是测试评论文本");
                    // 启动分享GUI
                    oks.show(context);
                }
            });




    }



    @Override
    public int getItemCount() {
        return list.size();
    }


    static class lineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tj_atten_simpleDrawee_icon)
        SimpleDraweeView tjAttenSimpleDraweeIcon;
        @BindView(R.id.tj_atten_tvname)
        TextView tjAttenTvname;
        @BindView(R.id.tj_atten_tvtime)
        TextView tjAttenTvtime;
        @BindView(R.id.tj_atten_tvtheme)
        TextView tjAttenTvtheme;
        @BindView(R.id.tj_atten_video)
        JZVideoPlayerStandard tjattenvideo;
        @BindView(R.id.attentj_zan)
        ImageView attentjzan;
        @BindView(R.id.attentj_share)
        ImageView attentjshare;
        private final ImageView dimage;
        private final ImageView attentj_xing;
        private final TextView attentj_zannum;
        private final TextView attentj_xingnum;

        lineViewHolder(View view) {
            super(view);
            dimage = view.findViewById(R.id.d_image);
            attentj_xing = view.findViewById(R.id.attentj_xing);
            attentj_zannum = view.findViewById(R.id.attentj_zannum);
            attentj_xingnum = view.findViewById(R.id.attentj_xingnum);


            ButterKnife.bind(this, view);
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }


}
