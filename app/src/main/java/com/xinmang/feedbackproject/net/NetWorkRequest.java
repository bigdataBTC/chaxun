package com.xinmang.feedbackproject.net;


import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.bean.PackageVersionNameData;
import com.xinmang.feedbackproject.utils.RxUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李佩
 * @date 2018/01/28
 * @desrcption 所有网络请求的封装
 */

public class NetWorkRequest {
    private static <M> void addObservable(Observable<M> observable, Subscriber<M> subscriber){
        RxUtils.getInstance().addSubscription(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public static void getFeedBackData(String where,int limit,int skip,Subscriber<FeedBackReusltData> subscriber){
        addObservable(ApiFactory.getServiceApi().getFeedBackData(where,limit,skip,"-updatedAt"),subscriber);

    }


    public static void getPackageVersionNameData(Subscriber<PackageVersionNameData> subscriber){
        addObservable(ApiFactory.getPackAgeVersionApi().getPackageVersion(),subscriber);

    }


}
