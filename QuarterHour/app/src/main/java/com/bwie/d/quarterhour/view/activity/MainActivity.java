package com.bwie.d.quarterhour.view.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;
import com.bwie.d.quarterhour.utils.SlideMenu;
import com.bwie.d.quarterhour.view.fragment.CrossTalkFragment;
import com.bwie.d.quarterhour.view.fragment.Funnyfragment;
import com.bwie.d.quarterhour.view.fragment.RecommendFragment;
import com.bwie.d.quarterhour.view.fragment.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;


public class MainActivity extends BaseActivity {


    private SimpleDraweeView menu_icon;
    private Button radio_01;
    private Button radio_02;
    private Button radio_03;
    private Button radio_04;
    private SlideMenu slideMenu;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initView() {
        //初始化控件
        slideMenu = (SlideMenu)findViewById(R.id.slideMenu);
        menu_icon = findViewById(R.id.menu_icon);
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
    }

    @Override
    void initData() {
        //初始化数据

        //圆形头像
        Uri uri = Uri.parse("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517015634&di=064833d0a882df2da895b8ad87d2336a&imgtype=jpg&er=1&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F289%2F01%2FIGS09651F94M.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
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
    }

    /**
     * 侧拉菜单的初始化数据
     */


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
