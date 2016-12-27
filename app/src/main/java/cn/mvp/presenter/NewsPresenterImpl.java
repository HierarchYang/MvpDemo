package cn.mvp.presenter;

import android.util.Log;

import cn.mvp.bean.NewsBean;
import cn.mvp.model.NewsModel;
import cn.mvp.model.NewsModelImpl;
import cn.mvp.ui.NewsView;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 17:17
 * Description:
 */

public class NewsPresenterImpl extends NewsPresenter implements NewsModelImpl.NewsOnListener {
    private static final String TAG = "NewsPresenterImpl";
    private NewsModel mNewsModel;
    private NewsView mNewsView;

    public NewsPresenterImpl(NewsView newsView) {
        this.mNewsView = newsView;
        mNewsModel = new NewsModelImpl(this);
    }

    @Override
    public void getNews(String type) {
        mNewsView.showProgress();
        addSubscription(mNewsModel.getNews(type));
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        mNewsView.hideProgress();
        mNewsView.getNews(newsBean);
    }

    @Override
    public void onFailure(Throwable throwable) {
        mNewsView.hideProgress();
        Log.i(TAG, "onFailure");
    }
}
