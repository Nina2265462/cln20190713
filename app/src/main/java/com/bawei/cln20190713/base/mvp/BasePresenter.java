package com.bawei.cln20190713.base.mvp;

import java.lang.ref.WeakReference;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public abstract class BasePresenter<M, V> {
    public M model;
    public V view;
    private WeakReference<V> weakReference;

    public abstract M getModel();

    public void attach(M model, V view) {
        this.model = model;
        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();
    }

    public void dettch() {
        if (model != null) {
            model = null;
        }
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
            view = null;
        }
    }
}
