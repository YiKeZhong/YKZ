package com.bwie.d.quarterhour.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class CreateActivity extends BaseActivity {

    private TextView create_cancle;

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
    }

    @Override
    int setContentViewId() {
        return R.layout.activity_create;
    }
}
