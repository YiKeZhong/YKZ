package com.bwie.d.quarterhour.view.adapter;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.AttenTJBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.sharesdk.onekeyshare.OnekeyShare;

import static com.mob.tools.utils.Strings.getString;

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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        String img_url = "https://v2.modao.cc/uploads3/images/1103/11038871/raw_1500002643.png";
        if (holder instanceof imgViewHolder) {
            ((imgViewHolder) holder).tjAttensimpleDrawee.setImageURI(img_url);
        } else if (holder instanceof lineViewHolder) {
            String user_icon = list.get(position).getUser().getIcon() + "";
            String big_img = list.get(position).getCover();
            String vidoe_url = list.get(position).getVideoUrl();

            ((lineViewHolder) holder).tjAttenTvname.setText(list.get(position).getUser().getNickname() + "");
            ((lineViewHolder) holder).tjAttenTvtime.setText(list.get(position).getCreateTime());
            ((lineViewHolder) holder).tjAttenSimpleDraweeIcon.setImageURI(user_icon);
            ((lineViewHolder) holder).tjAttenTvtheme.setText(list.get(position).getWorkDesc());
            //进行播放视频
            ((lineViewHolder) holder).tjattenvideo.setUp(vidoe_url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
            Glide.with(context).load(big_img).into(((lineViewHolder) holder).tjattenvideo.thumbImageView);

            ((lineViewHolder) holder).attentjzan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"we",Toast.LENGTH_SHORT).show();
                    //((lineViewHolder) holder).attentjzan.setImageResource(R.drawable.hong_xin);
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
    }



    /**
     * 离开时销毁播放器
     */
    public void stop() {
        JZVideoPlayer.releaseAllVideos();
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
        @BindView(R.id.tj_atten_tvtheme)
        TextView tjAttenTvtheme;
        @BindView(R.id.tj_atten_video)
        JZVideoPlayerStandard tjattenvideo;
        @BindView(R.id.attentj_zan)
        ImageView attentjzan;
        @BindView(R.id.attentj_share)
        ImageView attentjshare;

        lineViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
