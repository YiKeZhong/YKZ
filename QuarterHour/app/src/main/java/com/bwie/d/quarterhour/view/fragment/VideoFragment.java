package com.bwie.d.quarterhour.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.d.quarterhour.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by weicy on 2018/1/20.
 */

public class VideoFragment extends Fragment{


    @BindView(R.id.tablayout_video)
    TabLayout tablayoutVideo;
    @BindView(R.id.viewpager_video)
    ViewPager viewpagerVideo;
    Unbinder unbinder;
    Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<String> list = new ArrayList<>();
        list.add("热门");
        list.add("附近");

        ArrayList<Fragment> list1 = new ArrayList<>();
        list1.add(new VideoHotFragment());
        list1.add(new VideoNearbyFragment());

        viewpagerVideo.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {
                if (list.get(position).equals("热门")){
                    fragment = new VideoHotFragment();
                }else {
                    fragment = new VideoNearbyFragment();
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        tablayoutVideo.setupWithViewPager(viewpagerVideo);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
