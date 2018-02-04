package com.bwie.d.quarterhour.view.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.LoginqqBean;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    @BindView(R.id.Login_qita)
    TextView LoginQita;
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;

    @BindView(R.id.login_touxiang)
    ImageView loginTouxiang;
    @BindView(R.id.login_weix)
    Button loginWeix;
    @BindView(R.id.login_qqin)
    Button loginQqin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mTencent = Tencent.createInstance(APP_ID, LoginActivity.this.getApplicationContext());
        loginQqin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
                 官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
                 第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 */
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(LoginActivity.this, "all", mIUiListener);

            }
        });

        LoginQita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,LoginInActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 自定义监听器实现IUiListener接口后，需要实现的3个方法
     * onComplete完成 onError错误 onCancel取消
     */
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(final Object response) {
            Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(), qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object arg0) {
                        Log.e(TAG, "登录成功" + response.toString());
                        if (arg0 == null) {
                            return;
                        }
                        try {
                            JSONObject jo = (JSONObject) arg0;
                            int ret = jo.getInt("ret");
                            System.out.println("json=" + String.valueOf(jo));
                            String nickName = jo.getString("nickname");
                            String gender = jo.getString("figureurl");

                            Toast.makeText(LoginActivity.this, "你好，" + nickName + gender,
                                    Toast.LENGTH_LONG).show();
                            Log.i("liqiwenzp", gender);
                            Log.i("liqiwenwm", nickName);

                            EventBus.getDefault().postSticky(new LoginqqBean(nickName, gender));
                            finish();
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(LoginActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
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

