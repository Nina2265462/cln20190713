package com.bawei.cln20190713.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
