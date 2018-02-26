package com.xinmang.feedbackproject.mvp.model;

import com.xinmang.feedbackproject.base.BaseBriadgeData;
import com.xinmang.feedbackproject.base.BaseModel;
import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.bean.PackageVersionNameData;
import com.xinmang.feedbackproject.net.NetWorkRequest;
import com.xinmang.feedbackproject.net.NetWorkSubscriber;

/**
 * Created by lipei on 2018/1/30.
 */

public class MainModelLml implements BaseModel.MainModel{
    @Override
    public void getFeedBackNewWOrk(String where, int limit,int skip, BaseBriadgeData.mainData mainData) {
        NetWorkRequest.getFeedBackData(where,limit,skip,new NetWorkSubscriber<FeedBackReusltData>(){
            @Override
            public void onError(Throwable e) {
                mainData.error(e.toString());
                super.onError(e);

            }

            @Override
            public void onNext(FeedBackReusltData feedBackReusltData) {
                mainData.addData(feedBackReusltData);
                super.onNext(feedBackReusltData);

            }
        });

    }

    @Override
    public void getPackAgeVersion(BaseBriadgeData.mainData mainData) {
        NetWorkRequest.getPackageVersionNameData(new NetWorkSubscriber<PackageVersionNameData>(){
            @Override
            public void onError(Throwable e) {
               mainData.error(e.toString());
            }

            @Override
            public void onNext(PackageVersionNameData packageVersionNameData) {
             mainData.addPackageVersionData(packageVersionNameData);
            }
        });
    }
}
