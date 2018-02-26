package com.xinmang.feedbackproject.mvp.view;

import com.xinmang.feedbackproject.base.BaseMvpView;
import com.xinmang.feedbackproject.bean.FeedBackReusltData;

import java.util.List;

/**
 * Created by lipei on 2018/1/30.
 */

public interface MainView extends BaseMvpView {

    void requestLoading();
    /**
     * 请求成功
     * @param feedBackReusltData
     */
    void rueqestSuccess(FeedBackReusltData feedBackReusltData,boolean isRefresh);

    /**
     * 请求失败
     * @param error
     */
    void rueqestFail(String error);


    void setData(List<String> packageName,List<String> versionName);


    void setEmpty();

}
