package com.xinmang.feedbackproject.proxy;


import com.xinmang.feedbackproject.base.BaseMvpPresenter;
import com.xinmang.feedbackproject.base.BaseMvpView;
import com.xinmang.feedbackproject.factory.PresenterMvpFactory;

/**
 * @author 李佩
 * @date 2018/1/27
 * @description 代理接口
 */

public interface PresenterProxyInterface<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory的类型
     */

    void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return PresenterFactory的类型
     */

    PresenterMvpFactory<V,P> getPresenterFactory();

    /**
     * 获取指定类型的Presenter
     * @return 指定类型的Presenter
     */
    P getPresenter();
}
