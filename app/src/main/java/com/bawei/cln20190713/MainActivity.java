package com.bawei.cln20190713;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.cln20190713.base.BaseActivity;
import com.bawei.cln20190713.base.mvp.BasePresenter;
import com.bawei.cln20190713.contract.ILoginContract;
import com.bawei.cln20190713.entity.LoginEntity;
import com.bawei.cln20190713.model.LogModel;
import com.bawei.cln20190713.presenter.LogPresenter;

import butterknife.BindView;

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

    @Override
    public BasePresenter basePresenter() {
        return new LogPresenter();
    }

    @Override
    public void showLog(LoginEntity loginEntity) {

    }
}