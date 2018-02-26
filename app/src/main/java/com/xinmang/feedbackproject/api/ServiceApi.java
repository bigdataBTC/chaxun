package com.xinmang.feedbackproject.api;

import com.xinmang.feedbackproject.bean.FeedBackReusltData;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lipei on 2018/1/29.
 */

public interface ServiceApi {
    @Headers({"Content-Type:application/json",
              "X-LC-Id:rRwqwXD7KRAY6W9Ia1zavDSQ-gzGzoHsz",
              "X-LC-Key:NSVWkIedueXRiRhYdmIEQAMp"})
    @GET(ApiContants.Inquire)
    Observable<FeedBackReusltData> getFeedBackData(@Query("where") String where, @Query("limit") int limit,@Query("skip") int skip,@Query("order") String order);

}
