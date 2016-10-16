package com.hais.example.mvpdemo.v;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hais.example.mvpdemo.R;
import com.hais.example.mvpdemo.bean.UserInfo;
import com.hais.example.mvpdemo.p.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录页面
 * M层   对P层传递过来的userInfo进行登录(网络请求)判断,处理完成之后将处理结果回调给P层
 * V层   负责响应用户的交互(获取数据---->提示操作结果)
 * P层   传递完数据给M层处理之后,实例化回调对象,成功了就通知V层登录成功,失败了就通知V层显示错误信
 *       息，即数据逻辑的处理在P层，也相当于一个控制器
 */

public class MainActivity extends AppCompatActivity implements ILoginView{

    @Bind(R.id.et_login_name)
    EditText etLoginName;
    @Bind(R.id.et_login_password)
    EditText etLoginPassword;

    //一个p对象
    private LoginPresenter presenter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        presenter = new LoginPresenter(this);

    }

    @OnClick({R.id.tv_login_cancel, R.id.btn_login_to_login, R.id.checkBox})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login_cancel:
                finish();
                break;
            case R.id.btn_login_to_login:
                presenter.login();
                break;
            case R.id.checkBox:
                break;
        }
    }

    @Override
    public void showInfo(String info) {
        Toast.makeText(mContext,"登陆"+info,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(mContext,"登陆错误"+msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public UserInfo getUserLoginInfo() {
        return new UserInfo(etLoginName.getText().toString().trim()
                ,etLoginPassword.getText().toString().trim());
    }
}
