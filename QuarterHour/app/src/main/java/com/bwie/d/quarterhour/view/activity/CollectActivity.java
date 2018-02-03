package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.utils.IGetDataBase;
import com.bwie.d.quarterhour.view.adapter.CollectAdapter;
import com.bwie.d.quarterhour.view.adapter.HotAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CollectActivity extends BaseActivity {

    private ImageView image;
    private RecyclerView recyclerView;
    private List<HotBean.DataBean> data;
    private PopupWindow mPopWindow;
    private TextView shanchu;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        recyclerView = findViewById(R.id.recy1);
        shanchu = findViewById(R.id.fanhui);
    }

    @Override
    void initData() {
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CollectActivity.this,MainActivity.class));
                finish();
            }
        });
//数据请求
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);
        Call<HotBean> call = iGetDataBase.get();
        call.enqueue(new Callback<HotBean>() {
            @Override
            public void onResponse(Call<HotBean> call, Response<HotBean> response) {
                HotBean body = response.body();
                data = body.getData();
                if (data != null) {
                    Log.e( "onCreatedaView: ","123"+data.get(0).getCreateTime() );
                    recyclerView.setLayoutManager(new LinearLayoutManager(CollectActivity.this, LinearLayoutManager.VERTICAL, false));

                    CollectAdapter hotAdapter = new CollectAdapter(CollectActivity.this, data);
                    recyclerView.setAdapter(hotAdapter);
                    hotAdapter.notifyDataSetChanged();
                    hotAdapter.setOnItemClickListener(new CollectAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            //Toast.makeText(getActivity(),"12"+"--"+position,Toast.LENGTH_SHORT).show();
                            image = view.findViewById(R.id.d_image);
                            image.setImageResource(R.drawable.breduce);
                            //弹框
                            showPopupWindow(view);

                        }
                        private void showPopupWindow(final View vvv) {
                            View contentView = LayoutInflater.from(CollectActivity.this).inflate(R.layout.photo_popup_layout, null);
                            mPopWindow = new PopupWindow(contentView,
                                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                            mPopWindow.setContentView(contentView);
                            mPopWindow.setBackgroundDrawable(new BitmapDrawable());
                            mPopWindow.setOutsideTouchable(true);
                            mPopWindow.setAnimationStyle(R.style.AnimationPreview);
                            ColorDrawable dw = new ColorDrawable(0000000000);
                            mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                @Override
                                public void onDismiss() {
                                    ImageView image = vvv.findViewById(R.id.d_image);

                                    image.setImageResource(R.drawable.badd);
                                }
                            });

                            contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                            int  mShowMorePopupWindowWidth = -contentView.getMeasuredWidth();
                            int  mShowMorePopupWindowHeight = -contentView.getMeasuredHeight();
                            mPopWindow.showAsDropDown(vvv,mShowMorePopupWindowWidth, mShowMorePopupWindowHeight);

                        }
                    });

                }
            }
            @Override
            public void onFailure(Call<HotBean> call, Throwable t) {
                Log.e( "onFailureshibai: ","123"+t );
            }
        });
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_collect;
    }
}
