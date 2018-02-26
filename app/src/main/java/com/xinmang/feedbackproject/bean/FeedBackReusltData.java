package com.xinmang.feedbackproject.bean;

import java.util.List;

/**
 * Created by lipei on 2018/1/30.
 */

public class FeedBackReusltData {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * packageName : com.xinmang.feedbackproject
         * feedBackContent : 明年
         * buildLevel : 25
         * updatedAt : 2018-01-30T11:57:48.812Z
         * appName : FeedBackProject
         * objectId : 5a705dbc1b69e6003c5501b6
         * createdAt : 2018-01-30T11:57:48.812Z
         * contactInformation : 151979797
         * versionName : 2.0
         * brand : Meizu
         * versionCode : 1
         * buildVersion : 7.1.2
         * manufacturer : Meizu
         * model : M6 Note
         */

        private String packageName;
        private String feedBackContent;
        private String buildLevel;
        private String updatedAt;
        private String appName;
        private String objectId;
        private String createdAt;
        private String contactInformation;
        private String versionName;
        private String brand;
        private String versionCode;
        private String buildVersion;
        private String manufacturer;
        private String model;

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getFeedBackContent() {
            return feedBackContent;
        }

        public void setFeedBackContent(String feedBackContent) {
            this.feedBackContent = feedBackContent;
        }

        public String getBuildLevel() {
            return buildLevel;
        }

        public void setBuildLevel(String buildLevel) {
            this.buildLevel = buildLevel;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getContactInformation() {
            return contactInformation;
        }

        public void setContactInformation(String contactInformation) {
            this.contactInformation = contactInformation;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getBuildVersion() {
            return buildVersion;
        }

        public void setBuildVersion(String buildVersion) {
            this.buildVersion = buildVersion;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }
}
