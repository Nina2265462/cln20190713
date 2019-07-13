package com.bawei.cln20190713.presenter;

import com.bawei.cln20190713.contract.ILoginContract;
import com.bawei.cln20190713.entity.LoginEntity;
import com.bawei.cln20190713.net.LogCallBack;

import java.util.HashMap;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public class LogPresenter extends ILoginContract.ILonginPresenter {
    @Override
    protected void login(HashMap<String, String> params) {
        model.request(params, new LogCallBack() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                view.showLog(loginEntity);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
