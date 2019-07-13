package com.bawei.cln20190713.contract;


import com.bawei.cln20190713.base.mvp.BasePresenter;
import com.bawei.cln20190713.base.mvp.IBaseModel;
import com.bawei.cln20190713.base.mvp.IBaseView;
import com.bawei.cln20190713.entity.LoginEntity;
import com.bawei.cln20190713.model.LogModel;
import com.bawei.cln20190713.net.LogCallBack;

import java.util.HashMap;

/*
 *@Auther:cln
 *@Date: 2019/7/13
 *@Description:功能
 * */
public interface ILoginContract {
     abstract class ILonginPresenter extends BasePresenter<ILogionModel, ILogionView> {
         public abstract void login(HashMap<String, String> params);

        @Override
        public ILogionModel getModel() {
            return new LogModel();
        }
    }

    interface ILogionModel extends IBaseModel {
        void request(HashMap<String, String> params, LogCallBack logCallBack);
    }

    interface ILogionView extends IBaseView {
        void showLog(LoginEntity loginEntity);
    }

}
