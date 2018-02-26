package com.xinmang.feedbackproject;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.xinmang.feedbackproject.adapter.FeedBackAdapter;
import com.xinmang.feedbackproject.base.BaseActivity;
import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.databinding.ActivityMainBinding;
import com.xinmang.feedbackproject.factory.CreatePresenter;
import com.xinmang.feedbackproject.mvp.presenter.MainPresenter;
import com.xinmang.feedbackproject.mvp.view.MainView;
import com.xinmang.feedbackproject.utils.DensityUtil;
import com.xinmang.feedbackproject.utils.LogUtils;
import com.xinmang.feedbackproject.utils.ToastUtil;
import com.xinmang.feedbackproject.view.PopSpinnerView;
import java.util.List;

@CreatePresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainView, MainPresenter, ActivityMainBinding> implements MainView,PopSpinnerView.onPopItemOnclik{
    private FeedBackAdapter feedBackAdapter;
    private View view;

    /**
     * 获取布局文件
     */
    @Override
    protected int getLayoutContent() {
        return R.layout.activity_main;
    }

    /**
     * 初始化的方法
     */
    @Override
    protected void init() {
        setmTitle("反馈查询");
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        feedBackAdapter = new FeedBackAdapter();
        mBindingView.setRvLayoutManager(new LinearLayoutManager(mContext));
        mBindingView.setFeedBackAdapter(feedBackAdapter);
    }

    /**
     * 初始化监听
     */
    @Override
    protected void initEventer() {
        mBindingView.packageName.setonPopItemOnclik(this);
        mBindingView.vesrionName.setonPopItemOnclik(this);
        mBindingView.refresh.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
               getPresenter().ReFrash();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
               getPresenter().LoadMore();
            }
        });

        mBindingView.appNameInput.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                //获取当前界面可视部分
                getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //获取屏幕的高度
                int screenHeight = getWindow().getDecorView().getRootView().getHeight();
                //此处就是用来获取键盘的高度的， 在键盘没有弹出的时候 此高度为0 键盘弹出的时候为一个正数
                int heightDifference = screenHeight - r.bottom;
//                Log.d("Keyboard Size", "Size: " + heightDifference);
                showAViewOverKeyBoard(heightDifference);
            }
        });


    }


    @Override
    public void requestLoading() {
        getLoadingDialog("加载中...");
    }

    /**
     * 请求成功
     *
     * @param feedBackReusltData
     */
    @Override
    public void rueqestSuccess(FeedBackReusltData feedBackReusltData,boolean isRefresh) {
        mBindingView.refresh.finishRefreshing();
        mBindingView.refresh.finishLoadmore();
        hide();
        feedBackAdapter.addData(feedBackReusltData.getResults(), isRefresh);
        LogUtils.e("rueqestSuccess-->", feedBackReusltData.getResults().size() + "");

    }

    /**
     * 请求失败
     *
     * @param error
     */
    @Override
    public void rueqestFail(String error) {
        hide();
        LogUtils.e("error--->", error);

    }

    @Override
    public void setData(List<String> packageName, List<String> versionName) {
        mBindingView.packageName.init(0,packageName.size(), DensityUtil.dip2px(this, 180), new PopSpinnerView.NameFilter() {
            @Override
            public String filter(int position) {
                return packageName.get(position);
            }
        });

        mBindingView.vesrionName.init(1,versionName.size(), DensityUtil.dip2px(this, 180), new PopSpinnerView.NameFilter() {

            @Override
            public String filter(int position) {
                return versionName.get(position);
            }
        });

    }

    @Override
    public void setEmpty() {
        ToastUtil.showToast("没有数据!");
    }

    public void onClick(View view) {
        getPresenter().onClick(view,mBindingView.packageNameInput.getText().toString(),mBindingView.vesrionNameInput.getText().toString(),mBindingView.appNameInput.getText().toString());
    }

    @Override
    public void onclick(int type, int postion, String name) {
        getPresenter().onItemClick( type,  postion, name);
    }

    private void showAViewOverKeyBoard(int heightDifference) {
        if (heightDifference > 0) {//显示
            if (view == null) {//第一次显示的时候创建  只创建一次
                view = View.inflate(this, R.layout.sure_item, null);
                RelativeLayout.LayoutParams loginlayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                loginlayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                loginlayoutParams.bottomMargin = heightDifference;
                mBindingView.topLl.addView(view, loginlayoutParams);

            }
            view.setVisibility(View.VISIBLE);

        } else {//隐藏
            if (view != null) {
                view.setVisibility(View.GONE);
            }
        }


    }

}
