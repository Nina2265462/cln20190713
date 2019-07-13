package com.bawei.cln20190713.net;

import com.bawei.cln20190713.entity.LoginEntity;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public interface LogCallBack {
    void onSuccess(LoginEntity loginEntity);

    void onFail(String msg);
}
