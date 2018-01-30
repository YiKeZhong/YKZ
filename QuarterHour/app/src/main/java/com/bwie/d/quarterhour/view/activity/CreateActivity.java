package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class CreateActivity extends BaseActivity {

    private TextView create_cancle;
    private RelativeLayout create_shipin;
    private RelativeLayout create_duanzi;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initView() {
        create_cancle = findViewById(R.id.create_cancle);
        create_shipin = findViewById(R.id.create_shipin);
        create_duanzi = findViewById(R.id.create_duanzi);
    }

    @Override
    void initData() {
        //点击按钮进行取消创作
        create_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //点击按钮显示视频
        create_shipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateActivity.this,VideoActivity.class));
                //Toast.makeText(CreateActivity.this,"123",Toast.LENGTH_SHORT).show();
            }
        });
        //点击视频显示段子
        create_duanzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateActivity.this,CrossTalkActivity.class));
                //Toast.makeText(CreateActivity.this,"456",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_create;
    }
}
