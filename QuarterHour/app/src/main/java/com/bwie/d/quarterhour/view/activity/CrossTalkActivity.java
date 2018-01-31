package com.bwie.d.quarterhour.view.activity;

import android.app.Dialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.d.quarterhour.R;
import com.bwie.d.quarterhour.presenter.BasePresenter;

public class CrossTalkActivity extends BaseActivity{


    private TextView crosstalk_text;
    private EditText editText;
    private ImageView cross_image;
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Dialog dialog;
    private TextView takePhoto1;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    void initView() {
        crosstalk_text = findViewById(R.id.crosstalk_text);
        editText = findViewById(R.id.cross_edit);
        cross_image = findViewById(R.id.cross_image);
        takePhoto1 = findViewById(R.id.takePhoto);
    }

    @Override
    void initData() {
        //点击取消按键
        crosstalk_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length()<1){
                    finish();
                }else {
                    dialog = new Dialog(CrossTalkActivity.this,R.style.ActionSheetDialogStyle);
                    //填充对话框的布局
                    inflate = LayoutInflater.from(CrossTalkActivity.this).inflate(R.layout.dialog_layout, null);
                    //初始化控件
                    choosePhoto = (TextView) inflate.findViewById(R.id.choosePhoto);
                    takePhoto = (TextView) inflate.findViewById(R.id.takePhoto);
                    takePhoto.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(CrossTalkActivity.this,"是否保存",Toast.LENGTH_SHORT).show();

                        }
                    });
                    //将布局设置给Dialog
                    dialog.setContentView(inflate);
                    //获取当前Activity所在的窗体
                    Window dialogWindow = dialog.getWindow();
                    //设置Dialog从窗体底部弹出
                    dialogWindow.setGravity( Gravity.BOTTOM);
                    //获得窗体的属性
                    WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                    lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
                    dialogWindow.setAttributes(lp);
                    dialog.show();//显示对话框
                }


            }
        });



    }

    @Override
    int setContentViewId() {
        return R.layout.activity_cross_talk;
    }

 /*   @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.takePhoto:
                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                break;
            case R.id.choosePhoto:
                Toast.makeText(this,"点击了从相册选择",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                break;
            case R.id.cross_image:
                break;
        }
    }*/

}
