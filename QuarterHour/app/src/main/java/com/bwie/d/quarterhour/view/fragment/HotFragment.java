package com.bwie.d.quarterhour.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.model.bean.HotBean;
import com.bwie.d.quarterhour.utils.IGetDataBase;
import com.bwie.d.quarterhour.view.activity.MainActivity;
import com.bwie.d.quarterhour.view.adapter.HotAdapter;
import com.bwie.d.quarterhour.model.bean.AttenTJBean;
import com.bwie.d.quarterhour.presenter.AttenTJPresenter;
import com.bwie.d.quarterhour.view.IView.IAttenView;
import com.bwie.d.quarterhour.view.adapter.AttenRecyAdapter;
import com.bwie.d.quarterhour.view.adapter.FunnyRecyAdapter;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.zyao89.view.zloading.ZLoadingView;
import com.zyao89.view.zloading.Z_TYPE;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weicy on 2018/1/22.
 */

public class HotFragment extends Fragment implements IAttenView {
    private SpringView Spr;
    private TextView text_01;
    private String string;
    private View view;
    private List<HotBean.DataBean> data;
    private AttenTJPresenter attenTJPresenter;
    private AttenRecyAdapter attenRecyAdapter;
    private RecyclerView att_recyclerview;
    private ZLoadingView attentj_loading;
    private TextView atten_loadingtv;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        string = bundle.getString("name", "热门");
        Log.e("onCreateViewstring: ", string + "123123");
        if (string == "热门") {
            string = bundle.getString("name", "热门");
            Log.e("onCreateViewstring: ", string + "123123");
            if (string == "热门") {
                view = inflater.inflate(R.layout.hotfragment, container, false);
                recyclerView = view.findViewById(R.id.recy);
                Spr = view.findViewById(R.id.Spr);
                //数据请求
                Spr.setHeader(new DefaultHeader(getActivity()));
                Spr.setFooter(new DefaultFooter(getActivity()));
                Spr.setListener(new SpringView.OnFreshListener() {
                    @Override
                    public void onRefresh() {
                        //下拉刷新
                        Spr.onFinishFreshAndLoad();
                    }

                    @Override
                    public void onLoadmore() {
                        //上拉加载
                        Spr.onFinishFreshAndLoad();
                    }
                });
                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);
                Call<HotBean> call = iGetDataBase.get();
                call.enqueue(new Callback<HotBean>() {


                    @Override
                    public void onResponse(Call<HotBean> call, Response<HotBean> response) {
                        HotBean body = response.body();
                        data = body.getData();
                        if (data != null) {
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                            HotAdapter hotAdapter = new HotAdapter(getActivity(), data);
                            recyclerView.setAdapter(hotAdapter);
                        }

                    }

                    @Override
                    public void onFailure(Call<HotBean> call, Throwable t) {

                    }
                });


                /**
                 * 关注页面
                 */
            } else if (string == "关注") {
                view = inflater.inflate(R.layout.attentionfragment, container, false);
                att_recyclerview = view.findViewById(R.id.att_recyclerview);
                atten_loadingtv = view.findViewById(R.id.atten_loadingtv);
                attentj_loading = view.findViewById(R.id.attentj_loading);
                attentj_loading.setLoadingBuilder(Z_TYPE.INTERTWINE);//设置类型
                attentj_loading.setColorFilter(Color.BLUE);//设置颜色

                attenTJPresenter = new AttenTJPresenter();
                attenTJPresenter.attach(this);
                attenTJPresenter.getData();

                att_recyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                att_recyclerview.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
                attenRecyAdapter = new AttenRecyAdapter(getActivity());
                att_recyclerview.setAdapter(attenRecyAdapter);

            }
            return view;
        }
        return null;
    }

    @Override
    public void Successful(AttenTJBean attenTJBean) {
        if (attenTJBean.getData()!= null){
            List<AttenTJBean.DataBean> data = attenTJBean.getData();
            attenRecyAdapter.addData(data);
            attenRecyAdapter.notifyDataSetChanged();

            //数据加载成功时,进行隐藏动画
            attentj_loading.setVisibility(View.GONE);
            atten_loadingtv.setVisibility(View.GONE);
        }
    }

    @Override
    public void Failed(Disposable d) {
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //attenTJPresenter.Detach();
    }

}
