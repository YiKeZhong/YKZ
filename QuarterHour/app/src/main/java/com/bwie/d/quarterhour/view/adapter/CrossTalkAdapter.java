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
    public void onBindViewHolder(final IViewHolder holder, final int position) {
//图片的点击事件
        holder.dimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,position);


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
    private HotAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(HotAdapter.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    static class IViewHolder extends RecyclerView.ViewHolder{
        private final ImageView dimage;
        public IViewHolder(View itemView) {
            super(itemView);
            dimage = itemView.findViewById(R.id.d_image);

        }
    }

}
