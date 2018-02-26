package com.xinmang.feedbackproject.app;


/**
 * Created by lipei on 2018/1/29.
 */

public class Application extends android.app.Application {
    private static Application application;

    public static Application getInstance(){
        return application;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
//        // 初始化参数依次为 this, AppId, AppKey
//        AVOSCloud.initialize(this,"rRwqwXD7KRAY6W9Ia1zavDSQ-gzGzoHsz","NSVWkIedueXRiRhYdmIEQAMp");
//        AVOSCloud.setDebugLogEnabled(true);
//        JumpUtils.SetQQ(Contants.FEED_BCAK_QQ);  ///此处请填写你们本组的客服QQ
//        JumpUtils.SetEmail(Contants.FEED_BCK_EMAIL);  //此处请填写你们本组的邮件反馈邮箱
    }
}
