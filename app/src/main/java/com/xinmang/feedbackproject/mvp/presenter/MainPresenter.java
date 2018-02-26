package com.xinmang.feedbackproject.mvp.presenter;

import android.view.View;

import com.google.gson.Gson;
import com.xinmang.feedbackproject.R;
import com.xinmang.feedbackproject.base.BaseBriadgeData;
import com.xinmang.feedbackproject.base.BaseModel;
import com.xinmang.feedbackproject.base.BaseMvpPresenter;
import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.bean.PackageVersionNameData;
import com.xinmang.feedbackproject.bean.WhereData;
import com.xinmang.feedbackproject.mvp.model.MainModelLml;
import com.xinmang.feedbackproject.mvp.view.MainView;
import com.xinmang.feedbackproject.utils.LogUtils;
import com.xinmang.feedbackproject.view.PopSpinnerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lipei on 2018/1/30.
 */

public class MainPresenter extends BaseMvpPresenter<MainView> implements BaseBriadgeData.mainData {

    private BaseModel.MainModel mainModel;
    private String where = null;
    private String packageName_chose = "";
    private String versionName_chose = "";
    private String appName_chose="";
    private List<String> packageName = new ArrayList<>();
    private List<String> versionName = new ArrayList<>();
    private int skip = 0;
    private boolean isRefresh = true;

    public MainPresenter() {
        mainModel = new MainModelLml();
        mainModel.getPackAgeVersion(this);
    }

    public void onClick(View view,String packageName_input,String versionName_input,String appName_input) {
        switch (view.getId()) {
//            case R.id.request:
//                getView().requestLoading();
//                isRefresh = true;
//                getFeedBackData(null, 10);
//                break;
            case R.id.sure:
                WhereData whereData = new WhereData();
                WhereData.AppNameBean appNameBean=new WhereData.AppNameBean();
                isRefresh = true;
                skip = 0;
               if((!packageName_input.isEmpty()) && (!versionName_input.isEmpty()) && (!appName_input.isEmpty())){
                   whereData.setPackageName(packageName_input);
                   whereData.setVersionName(versionName_input);
                   appNameBean.set$regex(appName_input);
                   whereData.setAppName(appNameBean);
                   where=new Gson().toJson(whereData);
               }else if((!packageName_input.isEmpty()) && (!versionName_input.isEmpty())){
                   whereData.setPackageName(packageName_input);
                   whereData.setVersionName(versionName_input);
                   where=new Gson().toJson(whereData);
               }else if((!packageName_input.isEmpty()) && (!appName_input.isEmpty())){
                   whereData.setPackageName(packageName_input);
                   appNameBean.set$regex(appName_input);
                   whereData.setAppName(appNameBean);
                   where=new Gson().toJson(whereData);
               }else if((!versionName_input.isEmpty()) && (!appName_input.isEmpty())){
                   whereData.setVersionName(versionName_input);
                   appNameBean.set$regex(appName_input);
                   whereData.setAppName(appNameBean);
                   where=new Gson().toJson(whereData);
               }else if(!packageName_input.isEmpty()){
                   whereData.setPackageName(packageName_input);
                   where=new Gson().toJson(whereData);

               }else if(!versionName_input.isEmpty()){
                   whereData.setVersionName(versionName_input);
                   where=new Gson().toJson(whereData);

               }else if(!appName_input.isEmpty()){
                   appNameBean.set$regex(appName_input);
                   whereData.setAppName(appNameBean);
                   where=new Gson().toJson(whereData);

               }else {
                   where=null;
               }

                LogUtils.e("json-->", where);
                getView().requestLoading();
                getFeedBackData(where, 10);

                break;
        }
    }

    public void onItemClick(int type, int postion, String name) {
        WhereData whereData = new WhereData();
        isRefresh = true;
        switch (type) {
            case 0:
                skip = 0;
                //选择版本
                if (packageName.get(postion).equals("All")) {
                    packageName_chose = "";
                    if (!(versionName_chose.equals(""))) {
                        whereData.setVersionName(packageName_chose);
                        where = new Gson().toJson(whereData);
                    } else {
                        where = null;
                    }

                } else {
                    packageName_chose = packageName.get(postion);
                    if (!(versionName_chose.equals(""))) {
                        whereData.setVersionName(versionName_chose);
                    }
                    whereData.setPackageName(packageName_chose);
                    where = new Gson().toJson(whereData);
                }

                LogUtils.e("json-->", where);
                getView().requestLoading();
                getFeedBackData(where, 10);
                break;
            case 1:
                skip = 0;
                //选择版本
                if (versionName.get(postion).equals("All")) {
                    versionName_chose = "";
                    if (!(packageName_chose.equals(""))) {
                        whereData.setPackageName(packageName_chose);
                        where = new Gson().toJson(whereData);
                    } else {
                        where = null;
                    }

                } else {
                    versionName_chose = versionName.get(postion);
                    if (!(packageName_chose.equals(""))) {
                        whereData.setPackageName(packageName_chose);
                    }
                    whereData.setVersionName(versionName_chose);
                    where = new Gson().toJson(whereData);
                }

                LogUtils.e("json-->", where);
                getView().requestLoading();
                getFeedBackData(where, 10);
                break;
        }

    }

    public void LoadMore() {
        isRefresh = false;
        skip += 10;
        mainModel.getFeedBackNewWOrk(where, 10, skip, this);
    }

    public void ReFrash() {
        isRefresh = true;
        skip = 0;
        mainModel.getFeedBackNewWOrk(where, 10, skip, this);
    }

    private void getFeedBackData(String where, int limit) {
        mainModel.getFeedBackNewWOrk(where, limit, skip, this);
    }

    @Override
    public void addData(FeedBackReusltData mList) {
        LogUtils.e("mList-->", mList.getResults().size() + "");
        getView().rueqestSuccess(mList, isRefresh);
        if (mList.getResults().size() == 0) {
            getView().setEmpty();
        }

    }

    @Override
    public void addPackageVersionData(PackageVersionNameData packageVersionNameData) {
        packageName=packageVersionNameData.getPackageNamedata();
        versionName=packageVersionNameData.getVersionNamedata();
        getView().setData(packageName, versionName);


    }

    @Override
    public void error(String error) {
        getView().rueqestFail(error);

    }
}
