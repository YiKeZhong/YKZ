package com.bwie.d.quarterhour.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login_in);
        ButterKnife.bind(this);

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
    }

    @Override
    public void success(LoginInBean loginInBean) {
        Toast.makeText(LoginInActivity.this,loginInBean.getMsg().toString(),Toast.LENGTH_SHORT).show();
    }
}
