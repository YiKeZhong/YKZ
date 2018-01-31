package com.bwie.d.quarterhour.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.CrossTalkBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d on 2018/1/23.
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.IViewHolder>{

    List<CrossTalkBean.DataBean> data;
    FragmentActivity activity;
    private boolean isMenuOpen = false;
    private List<ImageView> textViews = new ArrayList<>();
    private List<TextView> textViews2 = new ArrayList<>();
    public CrossTalkAdapter(List<CrossTalkBean.DataBean> data, FragmentActivity activity) {
        this.data = data;
        this.activity = activity;
    }

    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.layout_crosstalk, null);
        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final IViewHolder holder, int position) {
        textViews.add(holder.timg);
        textViews.add(holder.warning);
        textViews.add(holder.banned);
        textViews2.add(holder.tv1);
        textViews2.add(holder.tv2);
        textViews2.add(holder.tv3);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isMenuOpen) {
                    showOpenAnim(180);
                    holder.timg.setVisibility(View.VISIBLE);
                    holder.warning.setVisibility(View.VISIBLE);
                    holder.banned.setVisibility(View.VISIBLE);
                    holder.tv1.setVisibility(View.VISIBLE);
                    holder.tv2.setVisibility(View.VISIBLE);
                    holder.tv3.setVisibility(View.VISIBLE);
                    holder.imageView.setImageResource(R.drawable.cross_toux);
                    //转动加号大图标本身
                    ObjectAnimator rotate = ObjectAnimator.ofFloat(holder.imageView, "rotation", 360, 0).setDuration(1000);
                    //this is 弹弹弹
                    //rotate.setInterpolator(new BounceInterpolator());
                    rotate.start();
                } else {
                    showCloseAnim(180);
                    holder.timg.setVisibility(View.GONE);
                    holder.banned.setVisibility(View.GONE);
                    holder.warning.setVisibility(View.GONE);
                    holder.tv1.setVisibility(View.GONE);
                    holder.tv2.setVisibility(View.GONE);
                    holder.tv3.setVisibility(View.GONE);
                    holder.imageView.setImageResource(R.drawable.cross_toux);
                    //转动加号大图标本身
                    ObjectAnimator rotate = ObjectAnimator.ofFloat(holder.imageView, "rotation", 0, 360).setDuration(1000);
                    //this is 弹弹弹
                    //rotate.setInterpolator(new BounceInterpolator());
                    rotate.start();
                }
            }
        });
    }

    private void showCloseAnim(int dp) {
        for (int i = 0; i < textViews.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            //double b = -Math.sin(20 * Math.PI / 180 * (i * 2 + 1));
            double x = a * dip2px(dp);
            //double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) y, (float) (y * 0.25)),
            set.playTogether(
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(textViews.get(i), "rotation", 0, 360).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 1, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews2.get(i), "translationX", (float) x, (float) (x * 0.25)),
                    ObjectAnimator.ofFloat(textViews2.get(i), "alpha", 1, 0).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new AccelerateInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {

                    //菜单状态置关闭
                    isMenuOpen = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }
                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

    }

    private int dip2px(int value) {
        float density = activity.getResources()
                .getDisplayMetrics().density;
        return (int) (density * value + 0.5f);
    }
    private void showOpenAnim(int dp) {

        //for循环来开始小图标的出现动画
        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.timg:
                            Toast.makeText(activity, "点击了1", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.warning:
                            Toast.makeText(activity, "点击了2", Toast.LENGTH_SHORT).show();

                            break;
                        case R.id.banned:
                            Toast.makeText(activity, "点击了3", Toast.LENGTH_SHORT).show();

                            break;
                    }
                }
            });
            AnimatorSet set = new AnimatorSet();
            double a = -(25 * Math.PI / 180 * (i + 1));
            double x = a * dip2px(dp);
            Log.e("aaa",a+"");
            // double y = b * dip2px(dp);
            //ObjectAnimator.ofFloat(textViews.get(i), "translationY", (float) (y * 0.25), (float) y),
            set.playTogether(
                    ObjectAnimator.ofFloat(textViews.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(textViews.get(i), "rotation", 360, 0).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews.get(i), "alpha", 0, 1).setDuration(1000),
                    ObjectAnimator.ofFloat(textViews2.get(i), "translationX", (float) (x * 0.25), (float) x),
                    ObjectAnimator.ofFloat(textViews2.get(i), "alpha", 0, 1).setDuration(1000)
            );
            //this is 弹弹弹
            //set.setInterpolator(new BounceInterpolator());
            set.setDuration(1000);
            set.start();

            set.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    //菜单状态置打开
                    isMenuOpen = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class IViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private ImageView timg;
        private ImageView warning;
        private ImageView banned;
        private ImageView imageView;
        public IViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_publish);
            timg = itemView.findViewById(R.id.timg);
            warning = itemView.findViewById(R.id.warning);
            banned = itemView.findViewById(R.id.banned);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }

}
