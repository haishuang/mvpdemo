package com.hais.example.mvpdemo.p;

import android.text.TextUtils;

import com.hais.example.mvpdemo.m.ILoginModel;
import com.hais.example.mvpdemo.m.LoginModel;
import com.hais.example.mvpdemo.m.Result;
import com.hais.example.mvpdemo.v.ILoginView;

/**
 * Created by Administrator on 2016/10/15.
 */

public class LoginPresenter implements ILoginPresenter {
    private ILoginModel loginModel;
    private ILoginView loginView;
    public LoginPresenter( ILoginView loginView) {
        this.loginModel = new LoginModel();
        this.loginView = loginView;
    }

    @Override
    public void login() {
        if(TextUtils.isEmpty(loginView.getUserLoginInfo().getUserName())){
            loginView.showErrorMsg("用户名不能为空");
            return;
        }
        if(TextUtils.isEmpty(loginView.getUserLoginInfo().getUserPassword())){
            loginView.showErrorMsg("密码不能为空");
            return;
        }
        loginModel.login(loginView.getUserLoginInfo(), new Result() {
            @Override
            public void success() {
                loginView.showInfo("登陆成功！");

            }
            @Override
            public void error() {
                loginView.showErrorMsg("错误");
            }
        });
    }
}
