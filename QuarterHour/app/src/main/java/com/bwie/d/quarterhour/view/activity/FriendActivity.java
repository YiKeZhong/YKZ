package com.bwie.d.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.FriendBean;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.utils.IGetDataBase;
import com.bwie.d.quarterhour.view.IView.FriendRetrofit;
import com.bwie.d.quarterhour.view.adapter.FriendAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendActivity extends BaseActivity {
    private TextView shanchu;
    private EditText reien_edit;
    private TextView friend_text;
    private RecyclerView friend_recy;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        shanchu = findViewById(R.id.fanhui);
        reien_edit = findViewById(R.id.reien_edit);
        friend_text = findViewById(R.id.friend_text);
        friend_recy = findViewById(R.id.friend_recy);
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
        friend_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reien_edit.length()==0){
                    Toast.makeText(FriendActivity.this,"无搜索内容",Toast.LENGTH_SHORT).show();
                }else {
                    Retrofit retrofit =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")

                    .addConverterFactory(GsonConverterFactory.create()) .build();
                    FriendRetrofit iGetDataBase = retrofit.create(FriendRetrofit.class);
                    Call<FriendBean> call = iGetDataBase.get(""+reien_edit.getText());
                    call.enqueue(new Callback<FriendBean>() {

                        @Override
                        public void onResponse(Call<FriendBean> call, Response<FriendBean> response) {
                            FriendBean body = response.body();
                            List<FriendBean.DataBean> data = body.getData();
                            if (data!=null){
                                friend_recy.setLayoutManager(new LinearLayoutManager(FriendActivity.this,LinearLayoutManager.VERTICAL,false));
                                FriendAdapter friendAdapter = new FriendAdapter(FriendActivity.this,data);
                                friend_recy.setAdapter(friendAdapter);
                            }else {
                                Log.e( "onResponse456456: ","12" );
                            }

                        }

                        @Override
                        public void onFailure(Call<FriendBean> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_friend;
    }
}
