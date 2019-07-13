package com.bawei.cln20190713.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bawei.cln20190713.base.mvp.BasePresenter;
import com.bawei.cln20190713.base.mvp.IBaseModel;
import com.bawei.cln20190713.base.mvp.IBaseView;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public abstract class BaseActivity<M extends IBaseModel, P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    private Unbinder bind;
    public M model;
    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bind = ButterKnife.bind(this);
        bintView();
        inits();
    }

    private void inits() {
        ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();
        presenter = (P) basePresenter();
        if (presenter != null) {
            model = (M) presenter.getModel();
            if (model != null) {
                presenter.attach(model, this);
            }
        }
        bindData();
    }

    protected abstract void bindData();

    public abstract int bindLayout();

    protected abstract void bintView();

    /**
     * 吐司
     *
     * @param con
     */
    public void showToase(String con) {
        Toast.makeText(this, con, Toast.LENGTH_SHORT).show();
    }

    /**
     * 无参数跳转
     */

    public void ParametricJump(Class<?> cls) {
        startActivity(new Intent(this, cls));

    }

    /**
     * 有参数跳转
     *
     * @param bundle
     * @param cls
     */
    public void ParametricJumps(Bundle bundle, Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

