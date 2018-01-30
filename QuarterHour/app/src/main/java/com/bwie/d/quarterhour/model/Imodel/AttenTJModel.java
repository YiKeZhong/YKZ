package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.view.IView.IAttenModel;
import com.bwie.d.quarterhour.model.bean.AttenTJBean;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;
import com.bwie.d.quarterhour.model.retrofit.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2018/1/23.
 */

public class AttenTJModel {

    public void getData(final IAttenModel iAttenModel) {

        HashMap<String,String> map = new HashMap<>();
        map.put("source","android");
        map.put("appVersion","101");
        Observable<String> stringObservable = RetrofitUtils.getInstance().get("/quarter/getVideos",map);
        stringObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<AttenTJBean>() {
                    @Override
                    public void success(AttenTJBean attenTJBean) {
                        iAttenModel.Successful(attenTJBean);
                    }

                    @Override
                    public void onfailure(Disposable d) {
                        iAttenModel.Failed(d);
                    }
                });
    }
}
