package com.xinmang.feedbackproject.base;


import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.bean.PackageVersionNameData;
import com.xinmang.feedbackproject.mvp.view.MainView;

/**
 * Created by 李佩
 * @date 2018/01/27
 * @description Model层和Presenter数据交互的桥梁
 */

public interface BaseBriadgeData<T> {

    void addData(T mList);

    void error(String error);

    interface mainData {
        void error(String error);

        void addData(FeedBackReusltData feedBackReusltData);

        void addPackageVersionData(PackageVersionNameData packageVersionNameData);
    }




}
