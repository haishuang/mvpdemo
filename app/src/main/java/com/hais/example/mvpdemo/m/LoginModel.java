package com.hais.example.mvpdemo.m;

import com.hais.example.mvpdemo.bean.UserInfo;

/**
 * Created by Administrator on 2016/10/15.
 *
 */

public class LoginModel implements ILoginModel {
    @Override
    public void login(UserInfo userInfo, Result result) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟网络请求部分
        if("XX".equals(userInfo.getUserName())&&"123".equals(userInfo.getUserPassword())){
            result.success();
        }else {
            result.error();
        }
    }




}
