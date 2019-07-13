package com.bawei.cln20190713.api;

import com.bawei.cln20190713.entity.LoginEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public interface ApiService {
    //注册
    @POST(Api.REG_URL)
    @FormUrlEncoded
    Observable<LoginEntity> reg(@FieldMap() HashMap<String, String> params);

    //登陆
    @POST(Api.LOG_URL)
    @FormUrlEncoded
    Observable<LoginEntity> log(@FieldMap() HashMap<String, String> params);
}
