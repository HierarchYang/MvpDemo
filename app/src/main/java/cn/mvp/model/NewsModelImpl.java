package cn.mvp.model;

import android.util.Log;

import cn.mvp.bean.NewsBean;
import cn.mvp.retrofit.ApiServiceManager;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 17:12
 * Description:
 */

public class NewsModelImpl implements NewsModel {
    private static final String TAG = "NewsModelImpl";
    private NewsOnListener mNewsOnListener;

    public NewsModelImpl(NewsOnListener newsOnListener) {
        this.mNewsOnListener = newsOnListener;
    }

    @Override
    public Subscription getNews(String type) {
        Observable<NewsBean> observable = ApiServiceManager.getNews(type);
        Subscription subscribe = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsBean>() {
                    @Override
                    public void call(NewsBean newsBean) {
                        if (mNewsOnListener != null) {
                            mNewsOnListener.onSuccess(newsBean);
                            Log.i(TAG, "NewsModelImpl" + newsBean.toString());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (mNewsOnListener != null) {
                            mNewsOnListener.onFailure(throwable);
                        }
                    }
                });
        return subscribe;
    }

    public interface NewsOnListener {
        void onSuccess(NewsBean newsBean);

        void onFailure(Throwable throwable);
    }
}
