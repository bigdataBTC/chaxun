package com.xinmang.feedbackproject.api;

import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.bean.PackageVersionNameData;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lipei on 2018/1/29.
 */

public interface PackAgeVersionApi {
    @GET(ApiContants.PackageVersionName)
    Observable<PackageVersionNameData> getPackageVersion();

}
