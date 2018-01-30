package com.bwie.d.quarterhour.model.Imodel;

import com.bwie.d.quarterhour.model.bean.LoginInBean;
import com.bwie.d.quarterhour.model.retrofit.AbstractObserver;
import com.bwie.d.quarterhour.model.retrofit.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by d on 2018/1/30.
 */

public class LoginModel{


    public void getlogin(String user, String pass, final LoginModelCallBack callBack){

        Map<String,String> map = new HashMap<>();
        map.put("mobile",user);
        map.put("password",pass);
        RetrofitUtils.getInstance().get("/user/login",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new AbstractObserver<LoginInBean>() {
                    @Override
                    public void success(LoginInBean loginInBean) {
                        callBack.success(loginInBean);
                    }

                    @Override
                    public void onfailure(Disposable d) {

                    }
                });
    }

    public interface LoginModelCallBack{
     public void success(LoginInBean loginInBean);
    }
}
