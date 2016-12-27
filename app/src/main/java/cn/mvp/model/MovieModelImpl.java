package cn.mvp.model;

import android.util.Log;

import cn.mvp.bean.MovieBean;
import cn.mvp.retrofit.ApiServiceManager;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月27日 14:55
 * Description:
 */

public class MovieModelImpl implements MovieModel {

    private static final String BASE_MOVIES = "https://api.douban.com/";
    private static final String TAG = "MovieModelImpl";
    private OnMoviesListener mOnMoviesListener;

    public MovieModelImpl(OnMoviesListener onMoviesListener) {
        this.mOnMoviesListener = onMoviesListener;
    }

    @Override
    public Subscription getMovies(int start, int count) {
        Observable<MovieBean> observable = ApiServiceManager.getMovies(BASE_MOVIES, start, count);
        Subscription subscribe = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "MovieModelImpl-------->>onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mOnMoviesListener != null) {
                            mOnMoviesListener.onFailure(e);
                        }
                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        if (mOnMoviesListener != null) {
                            mOnMoviesListener.onSuccess(movieBean);
                        }
                    }
                });
        return subscribe;
    }

    public interface OnMoviesListener {
        void onSuccess(MovieBean movieBean);

        void onFailure(Throwable throwable);
    }
}
