package com.bwie.d.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.AttentionBean;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.utils.IGetDataBase;
import com.bwie.d.quarterhour.view.IView.AttentionRetrofit;
import com.bwie.d.quarterhour.view.adapter.AttentionAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AttentionActivity extends BaseActivity {

    private TextView shanchu;
    private RecyclerView attention_recy;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        shanchu = findViewById(R.id.fanhui);
        attention_recy = findViewById(R.id.attention_recy);
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
        Retrofit retrofit =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AttentionRetrofit attentionRetrofit = retrofit.create(AttentionRetrofit.class);
        Call<AttentionBean> attentionBeanCall = attentionRetrofit.get();
        attentionBeanCall.enqueue(new Callback<AttentionBean>() {
            @Override
            public void onResponse(Call<AttentionBean> call, Response<AttentionBean> response) {
                AttentionBean body = response.body();
                if (body!=null){
                    List<AttentionBean.DataBean> list = body.getData();
                    attention_recy.setLayoutManager(new LinearLayoutManager(AttentionActivity.this,LinearLayoutManager.VERTICAL,false));
                    AttentionAdapter attentionAdapter = new AttentionAdapter(AttentionActivity.this,list);
                    attention_recy.setAdapter(attentionAdapter);
                }
                Log.e( "onResponse: ",body.getData().get(0).getIcon() );
            }

            @Override
            public void onFailure(Call<AttentionBean> call, Throwable t) {

            }
        });


    }

    @Override
    int setContentViewId() {
        return R.layout.activity_attention;
    }
}
