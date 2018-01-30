package com.bwie.d.quarterhour.view.activity;

import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class CrossTalkActivity extends BaseActivity {


    private TextView crosstalk_text;
    private EditText editText;
    private ImageView cross_image;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        crosstalk_text = findViewById(R.id.crosstalk_text);
        editText = findViewById(R.id.cross_edit);
        cross_image = findViewById(R.id.cross_image);
    }

    @Override
    void initData() {
        //点击取消按键
        crosstalk_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length()<1){
                    finish();
                }else {
                    Toast.makeText(CrossTalkActivity.this,"是否保存",Toast.LENGTH_SHORT).show();

                }

            }
        });
        //点击图片
        cross_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    int setContentViewId() {
        return R.layout.activity_cross_talk;
    }
}
