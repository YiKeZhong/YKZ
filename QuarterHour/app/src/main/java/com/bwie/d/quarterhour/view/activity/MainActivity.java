package com.bwie.d.quarterhour.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.LoginqqBean;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.utils.SlideMenu;
import com.bwie.d.quarterhour.view.fragment.CrossTalkFragment;
import com.bwie.d.quarterhour.view.fragment.Funnyfragment;
import com.bwie.d.quarterhour.view.fragment.RecommendFragment;
import com.bwie.d.quarterhour.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.suke.widget.SwitchButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;




public class MainActivity extends BaseActivity{


    private SimpleDraweeView menu_icon;
    private Button radio_01;
    private Button radio_02;
    private Button radio_03;
    private Button radio_04;
    private SlideMenu slideMenu;
    private TextView textView;
    private View main_bianji;
    private LinearLayout loginLayout;
    private SwitchButton switchButton;
    private TextView login_wm;
    private SimpleDraweeView draweeView;
    private TextView guanzhu;
    private TextView shoucang;
    private TextView haoyou;
    private TextView tongzhi;
    private RadioButton shezhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initView() {
        //初始化控件
        slideMenu = (SlideMenu)findViewById(R.id.slideMenu);
        menu_icon = findViewById(R.id.menu_icon);
        loginLayout = findViewById(R.id.menu_backgroud);
        //底部
        radio_01 = (Button) findViewById(R.id.radio_01);
        radio_02 = (Button) findViewById(R.id.radio_02);
        radio_03 = (Button) findViewById(R.id.radio_03);
        radio_04 = (Button) findViewById(R.id.radio_04);
        //初始化控件
        slideMenu = (SlideMenu)findViewById(R.id.slideMenu);
        //底部
        radio_01 = (Button) findViewById(R.id.radio_01);
        radio_02 = (Button) findViewById(R.id.radio_02);
        radio_03 = (Button) findViewById(R.id.radio_03);
        radio_04 = (Button) findViewById(R.id.radio_04);
        textView = findViewById(R.id.text);
        main_bianji = findViewById(R.id.main_bianji);
        switchButton = findViewById(R.id.switch_button);
        login_wm = findViewById(R.id.login_wm);
        //侧滑
        guanzhu = findViewById(R.id.guanzhu);
        shoucang = findViewById(R.id.shoucang);
        haoyou = findViewById(R.id.haoyou);
        tongzhi = findViewById(R.id.tongzhi);
        shezhi = findViewById(R.id.shezhi);

    }

    @Override
    void initData() {
        //初始化数据
        initMenu();

        //EventBus.getDefault().register(this);
        EventBus.getDefault().register(this);
        //ThemeManager.registerThemeChangeListener(this);
        //EventBus.getDefault().register(this);
        //圆形头像
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517015634&di=064833d0a882df2da895b8ad87d2336a&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F289%2F01%2FIGS09651F94M.jpg");
        draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);
        //点击出侧拉
        draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });
        RecommendFragment recommendFragment = new RecommendFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        radio_01.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.tuijian_02), null, null);
        fragmentTransaction.replace(R.id.frameLayout, recommendFragment);
        fragmentTransaction.commit();
        //推荐
        radio_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("推荐");
                RecommendFragment recommendFragment = new RecommendFragment();
                radio_01.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.tuijian_02), null, null);
                radio_02.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.duanzi_01), null, null);
                radio_03.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.shipin_01), null, null);
                radio_04.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.qutu_01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, recommendFragment);
                fragmentTransaction.commit();
            }
        });
        //段子
        radio_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("段子");
                CrossTalkFragment crossTalkFragment = new CrossTalkFragment();
                radio_01.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.tuijian_01), null, null);
                radio_02.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.duanzi_02), null, null);
                radio_03.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.shipin_01), null, null);
                radio_04.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.qutu_01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, crossTalkFragment);
                fragmentTransaction.commit();
            }
        });
        //视频
        radio_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("视频");
                VideoFragment videoFragment = new VideoFragment();
                radio_01.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.tuijian_01), null, null);
                radio_02.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.duanzi_01), null, null);
                radio_03.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.shipin_02), null, null);
                radio_04.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.qutu_01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, videoFragment);
                fragmentTransaction.commit();
            }
        });
        //趣图
        radio_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("趣图");
                Funnyfragment funnyfragment = new Funnyfragment();
                VideoFragment videoFragment = new VideoFragment();
                radio_01.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.tuijian_01), null, null);
                radio_02.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.duanzi_01), null, null);
                radio_03.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.shipin_01), null, null);
                radio_04.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.qutu_02), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, funnyfragment);
                fragmentTransaction.commit();
            }
        });

        /**
         * 点击编辑按钮跳转到创作页面
         */
        main_bianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CreateActivity.class));
            }
        });

        loginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //关注
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AttentionActivity.class));

            }
        });
        //收藏
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CollectActivity.class));
            }
        });
        //好友
        haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FriendActivity.class));
            }
        });
        //通知
        tongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InformActivity.class));
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShiZhiActivity.class));
            }
        });


    }

    /**
     * 侧拉菜单的初始化数据
     */
    public void initMenu(){
        //圆形头像
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517015634&di=064833d0a882df2da895b8ad87d2336a&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F289%2F01%2FIGS09651F94M.jpg");
        menu_icon.setImageURI(uri);
    }
    @Subscribe(sticky = true)
    public void getQQLogin(LoginqqBean loginqqBean){
        menu_icon.setImageURI(loginqqBean.getUsertx());
        draweeView.setImageURI(loginqqBean.getUsertx());
        login_wm.setText(loginqqBean.getUsername());
    }





    @Override
    int setContentViewId() {
        //指定引用布局
        return R.layout.activity_main;

    }

    @Override
    public BasePresenter initPresenter() {
        //初始化Presenter
        return null;
    }

}
