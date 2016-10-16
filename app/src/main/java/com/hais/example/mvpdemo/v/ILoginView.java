package com.hais.example.mvpdemo.v;

import android.content.Context;

import com.hais.example.mvpdemo.bean.UserInfo;

/**
 * Created by Administrator on 2016/10/16.
 */

public interface ILoginView {
    void showInfo(String info);//提示用户
    void showErrorMsg(String msg);//发生错误就显示错误信息
    UserInfo getUserLoginInfo();//获取用户登录信息
}
