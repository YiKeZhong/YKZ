package com.bwie.d.quarterhour.presenter;

import com.bwie.d.quarterhour.model.Imodel.LoginModel;
import com.bwie.d.quarterhour.model.bean.LoginInBean;
import com.bwie.d.quarterhour.view.IView.LoginCallBack;

/**
 * Created by d on 2018/1/30.
 */

public class LoginPresenter {
    LoginCallBack loginCallBack;
    private final LoginModel loginModel;

    public LoginPresenter(LoginCallBack loginCallBack){
       this.loginCallBack = loginCallBack;
        loginModel = new LoginModel();
    }

    public void getLogin(String user,String pass){
        loginModel.getlogin(user, pass, new LoginModel.LoginModelCallBack() {
            @Override
            public void success(LoginInBean loginInBean) {
                loginCallBack.success(loginInBean);
            }
        });

    }
}
