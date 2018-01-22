package com.bwie.d.quarterhour.view.fragment;


import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.bwie.d.quarterhour.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Field;


/**
 * Created by weicy on 2018/1/20.
 */

public class RecommendFragment extends Fragment {

    private RadioButton recommend_radio_01;
    private RadioButton recommend_radio_02;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommendfragment, container, false);
       /* recommend_radio_01 = view.findViewById(R.id.recommend_radio_01);
        recommend_radio_02 = view.findViewById(R.id.recommend_radio_02);
        recommend_radio_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotFragment hotFragment = new HotFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.recommend_frameLayout, hotFragment);
                fragmentTransaction.commit();
            }
        });
        recommend_radio_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttentionFragment attentionFragment = new AttentionFragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.recommend_frameLayout, attentionFragment);
                fragmentTransaction.commit();
            }
        });*/
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);

        list = new ArrayList<>();
        list.add("全部");
        list.add("关注");
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(tabLayout,60,60);
            }
        });


        //Viewpager要展示页面...设置适配器
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //得到当前页的标题,,,也就是设置当前页面显示的标题是tab对应的标题
            @Override
            public CharSequence getPageTitle(int position) {

                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                //一般我们在这个位置对比一下标题是什么,,,然后返回对应的fragment
                HotFragment hotFragment = new HotFragment();
                Bundle bundle = new Bundle();

                //Fragment fragment = null;

                if (list.get(position).equals("热门")){

                    //fragment = new TouTiaoFragment();
                    bundle.putString("name","热门");
                }else if (list.get(position).equals("关注")){
                    bundle.putString("name","关注");
                }

                hotFragment.setArguments(bundle);


                return hotFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


        //tablayout要与viewpager关联
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
    public void setIndicator (TabLayout tabs,int leftDip,int rightDip){
        Class<?> tabLayout = tabs.getClass();
        java.lang.reflect.Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }
}
