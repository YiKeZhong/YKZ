package com.bwie.d.quarterhour.presenter;

import android.support.v4.app.FragmentActivity;

import com.bwie.d.quarterhour.model.Imodel.IAttenModel;
import com.bwie.d.quarterhour.model.bean.AttenTJBean;
import com.bwie.d.quarterhour.model.http.AttenTJModel;
import com.bwie.d.quarterhour.view.IView.IAttenView;
import com.bwie.d.quarterhour.view.fragment.HotFragment;

import io.reactivex.disposables.Disposable;

/**
 * Created by ztz on 2018/1/23.
 */

public class AttenTJPresenter implements IAttenModel{

    private AttenTJModel attenTJModel;

    public AttenTJPresenter(){
       this.attenTJModel = new AttenTJModel();
   }

    private IAttenView iAttenView;
    public void attach(IAttenView iAttenView) {
        this.iAttenView = iAttenView;
    }

    public void getData() {
        attenTJModel.getData(this);
    }

    @Override
    public void Successful(AttenTJBean attenTJBean) {
        iAttenView.Successful(attenTJBean);
    }

    @Override
    public void Failed(Disposable d) {
        iAttenView.Failed(d);
    }
    public void Detach(){
        if (iAttenView != null){
            iAttenView = null;
        }
    }

}
