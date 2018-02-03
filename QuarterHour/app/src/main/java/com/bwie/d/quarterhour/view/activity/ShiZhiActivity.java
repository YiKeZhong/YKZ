package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class ShiZhiActivity extends BaseActivity {


    private TextView fanhui;
    private Button tuichudenglu;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        fanhui = findViewById(R.id.fanhui);
        tuichudenglu = findViewById(R.id.tuichudenglu);
    }

    @Override
    void initData() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tuichudenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShiZhiActivity.this,LoginActivity.class));

                finish();
            }
        });
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_shi_zhi;
    }
}
