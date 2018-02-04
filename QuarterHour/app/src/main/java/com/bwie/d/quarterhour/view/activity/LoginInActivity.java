package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.LoginInBean;
import com.bwie.d.quarterhour.presenter.LoginPresenter;
import com.bwie.d.quarterhour.view.IView.LoginCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginInActivity extends AppCompatActivity implements LoginCallBack {

    @BindView(R.id.Login_user)
    EditText LoginUser;
    @BindView(R.id.Login_pass)
    EditText LoginPass;
    @BindView(R.id.login_deng)
    Button loginDeng;
    private LoginPresenter loginPresenter;
    private TextView login_text;
    private TextView zhucezhanghao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login_in);
        ButterKnife.bind(this);
        login_text = findViewById(R.id.login_text);
        zhucezhanghao = findViewById(R.id.zhucezhanghao);
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loginPresenter = new LoginPresenter(this);
        loginDeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = LoginUser.getText().toString().trim();
                String pass = LoginPass.getText().toString().trim();
                if(!TextUtils.isEmpty(user)||!TextUtils.isEmpty(pass)){
                    loginPresenter.getLogin(user,pass);
                }
            }
        });
        //注册
        zhucezhanghao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginInActivity.this,RegisterActivity.class));
            }
        });
    }

    @Override
    public void success(LoginInBean loginInBean) {
        Toast.makeText(LoginInActivity.this,loginInBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
