package com.bawei.cln20190713.model;

import com.bawei.cln20190713.api.ApiService;
import com.bawei.cln20190713.contract.ILoginContract;
import com.bawei.cln20190713.entity.LoginEntity;
import com.bawei.cln20190713.net.LogCallBack;
import com.bawei.cln20190713.net.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public class LogModel implements ILoginContract.ILogionModel {
    @Override
    public void request(HashMap<String, String> params, final LogCallBack logCallBack) {
        RetrofitUtil.getUtil().getService(ApiService.class)
                .log(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        logCallBack.onSuccess(loginEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        logCallBack.onFail(throwable.getMessage());
                    }
                });
    }
}
