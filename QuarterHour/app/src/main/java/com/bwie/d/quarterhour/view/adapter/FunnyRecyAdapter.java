package com.bwie.d.quarterhour.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ztz on 2018/1/22.
 */

public class FunnyRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mList = new ArrayList<>();
    private Context context;
    private ArrayList<Integer> mHeights;

    public FunnyRecyAdapter(Context context) {
        this.context = context;
    }

    private List<String> list;
    public void addData(List<String> list) {
        this.list = list;
        if (list != null) {
            for(int i=0;i< list.size();i++){
                mList.add(list.get(i));
            }
            getRandomHight();
        }
    }

    //加载更多
    private List<String> loadList;
    public void loadData(List<String> loadList) {
        this.loadList = loadList;
        if (loadList != null) {
            for(int i=0;i< loadList.size();i++){
                mList.add(loadList.get(i));
            }
            getRandomHight();
        }
    }
    public void getRandomHight(){
        mHeights = new ArrayList<>();
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_funnyrecy_layout, parent, false);
        return new FunnyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FunnyViewHolder){

            ViewGroup.LayoutParams layoutParams = ((FunnyViewHolder) holder).funnyText.getLayoutParams();
            layoutParams.height = mHeights.get(position);
            ((FunnyViewHolder) holder).funnyText.setLayoutParams(layoutParams);

            ((FunnyViewHolder) holder).funnyText.setText(mList.get(position));

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class FunnyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.funny_text)
        TextView funnyText;

        FunnyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
