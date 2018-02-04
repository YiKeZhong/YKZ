package com.bwie.d.quarterhour.model.bean;

import java.util.List;

/**
 * Created by 张继业 on 2018/1/31.
 */

public class VideoNearBean {


    /**
     * msg : 获取附近作品列表成功
     * code : 0
     * data : []
     */

    private String msg;
    private String code;
    private List<?> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
