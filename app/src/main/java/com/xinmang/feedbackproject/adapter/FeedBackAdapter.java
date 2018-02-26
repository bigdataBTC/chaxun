package com.xinmang.feedbackproject.adapter;

import android.view.ViewGroup;

import com.xinmang.feedbackproject.R;
import com.xinmang.feedbackproject.base.baseadapter.BaseRecyclerViewAdapter;
import com.xinmang.feedbackproject.base.baseadapter.BaseRecyclerViewHolder;
import com.xinmang.feedbackproject.bean.FeedBackReusltData;
import com.xinmang.feedbackproject.databinding.ItemFeedBackBinding;

/**
 * Created by lipei on 2018/1/30.
 */

public class FeedBackAdapter extends BaseRecyclerViewAdapter<FeedBackReusltData.ResultsBean> {

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_feed_back);
    }

    private class ViewHolder extends BaseRecyclerViewHolder<FeedBackReusltData.ResultsBean,ItemFeedBackBinding>{

        ViewHolder(ViewGroup parent, int layout) {
            super(parent, layout);
        }
        /**
         * @param object  绑定的数据
         * @param postion RecyclerView的postion
         */
        @Override
        public void onBindViewHolder(FeedBackReusltData.ResultsBean object, int postion) {
            mBinding.setResultsBean(object);
            mBinding.executePendingBindings();

        }
    }
}
