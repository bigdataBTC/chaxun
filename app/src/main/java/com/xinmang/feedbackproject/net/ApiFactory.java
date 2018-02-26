package com.xinmang.feedbackproject.net;


import com.xinmang.feedbackproject.api.PackAgeVersionApi;
import com.xinmang.feedbackproject.api.ServiceApi;

/**
 * Created by lipei on 2018/1/29.
 */

public class ApiFactory {
    protected static  final  Object monitor=new Object();
    static ServiceApi serviceApi=null;

    static PackAgeVersionApi packAgeVersionApi=null;

    public static ServiceApi getServiceApi(){
        synchronized (monitor){
            if(serviceApi==null){
                serviceApi=new ApiRetrofit().getZhihuApiService();
            }
            return serviceApi;
        }
    }

    public static PackAgeVersionApi getPackAgeVersionApi(){
        synchronized (monitor){
            if(packAgeVersionApi==null){
                packAgeVersionApi=new ApiRetrofit().getPackAgeVersionApi();
            }
            return packAgeVersionApi;
        }
    }
}
