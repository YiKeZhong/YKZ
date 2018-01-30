package com.bwie.d.quarterhour.model.bean;

/**
 * Created by d on 2018/1/29.
 */

public class LoginqqBean {

    String username;
    String usertx;


    public LoginqqBean(String username, String usertx) {
        this.username = username;
        this.usertx = usertx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertx() {
        return usertx;
    }

    public void setUsertx(String usertx) {
        this.usertx = usertx;
    }

    @Override
    public String toString() {
        return "LoginqqBean{" +
                "username='" + username + '\'' +
                ", usertx='" + usertx + '\'' +
                '}';
    }
}
