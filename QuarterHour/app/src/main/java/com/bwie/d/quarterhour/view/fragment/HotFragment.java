package com.bwie.d.quarterhour.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.d.quarterhour.R;

/**
 * Created by weicy on 2018/1/22.
 */

public class HotFragment extends Fragment {

    private TextView text_01;
    private String string;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        string = bundle.getString("name", "全部");
        Log.e( "onCreateViewstring: ", string+"123123");
        if (string == "全部"){
            view = inflater.inflate(R.layout.hotfragment, container, false);

        }else if (string == "关注"){
            view = inflater.inflate(R.layout.attentionfragment, container, false);

        }
        return view;
    }

}
