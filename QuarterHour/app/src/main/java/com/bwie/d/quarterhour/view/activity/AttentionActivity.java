package com.bwie.d.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class AttentionActivity extends BaseActivity {

    private TextView shanchu;
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
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
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_attention;
    }
}
