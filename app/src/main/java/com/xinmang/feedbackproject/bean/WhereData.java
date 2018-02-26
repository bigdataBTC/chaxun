package com.xinmang.feedbackproject.bean;

/**
 * Created by lipei on 2018/2/1.
 */

public class WhereData {

    /**
     * appName : {"$regex":"手机"}
     * packageName : 军训基地就
     * versionName : 大家觉得
     */

    private AppNameBean appName;
    private String packageName;
    private String versionName;

    public AppNameBean getAppName() {
        return appName;
    }

    public void setAppName(AppNameBean appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public static class AppNameBean {
        /**
         * $regex : 手机
         */

        private String $regex;

        public String get$regex() {
            return $regex;
        }

        public void set$regex(String $regex) {
            this.$regex = $regex;
        }
    }
}
