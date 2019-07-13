package com.bawei.cln20190713;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.cln20190713.base.BaseActivity;
import com.bawei.cln20190713.base.mvp.BasePresenter;
import com.bawei.cln20190713.contract.ILoginContract;
import com.bawei.cln20190713.entity.LoginEntity;
import com.bawei.cln20190713.model.LogModel;
import com.bawei.cln20190713.presenter.LogPresenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity
        extends BaseActivity<LogModel, ILoginContract.ILonginPresenter>
        implements ILoginContract.ILogionView {

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.cb)
    CheckBox cb;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.eye)
    ImageView eye;
    private boolean isHideFirst = true;// 输入框密码是否是隐藏的，默认为true

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void bintView() {

    }


    @Override
    protected void bindData() {

    }
    @OnClick({R.id.cb, R.id.tv, R.id.login, R.id.eye})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb:
                break;
            case R.id.tv:
                break;
            case R.id.login:
                //判断登录前是否选中记住密码
                if (!TextUtils.isEmpty(phone.getText().toString()) || !TextUtils.isEmpty(pwd.getText().toString())) {
                    if (phone.getText().toString().length() != 11) {
                        Toast.makeText(this, "手机号应为11位", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(this, HomeActivity.class));
                    }
                } else {
                    //判断输入框是否为空
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.eye:
                if (isHideFirst == true) {
                    eye.setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                    //密文
                    HideReturnsTransformationMethod method1 = HideReturnsTransformationMethod.getInstance();
                    pwd.setTransformationMethod(method1);
                    isHideFirst = false;
                } else {
                    eye.setImageResource(R.mipmap.eye);
                    //密文
                    TransformationMethod method = PasswordTransformationMethod.getInstance();
                    pwd.setTransformationMethod(method);
                    isHideFirst = true;
                }
                // 光标的位置
                int index = pwd.getText().toString().length();
                pwd.setSelection(index);
                break;
        }
    }

    @Override
    public BasePresenter basePresenter() {
        return new LogPresenter();
    }

    @Override
    public void showLog(LoginEntity loginEntity) {
        HashMap<String, String> params = new HashMap<>();
        params.put("phone", phone.getText().toString());
        params.put("pwd", pwd.getText().toString());
        presenter.login(params);
        Toast.makeText(this, "" + loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
    }
}