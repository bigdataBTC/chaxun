package com.xinmang.feedbackproject.base;

/**
 * Created by 李佩
 * @date 2018/01/27
 * @description model层的基类
 */

public interface BaseModel<T> {
    void netWork(T mList);

    interface MainModel {
        void getFeedBackNewWOrk(String where,int limit,int skip,BaseBriadgeData.mainData mainData);

        void getPackAgeVersion(BaseBriadgeData.mainData mainData);
    }

}
