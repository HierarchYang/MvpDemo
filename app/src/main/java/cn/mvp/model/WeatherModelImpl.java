package cn.mvp.model;

import cn.mvp.bean.WeatherData;
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
 * @date : 2016年12月26日 16:53
 * Description:
 */

public class WeatherModelImpl implements WeatherModel {
    private WeatherOnListener mWeatherOnListener;


    public WeatherModelImpl(WeatherOnListener mWeatherOnListener) {
        this.mWeatherOnListener = mWeatherOnListener;
    }

    @Override
    public Subscription getWeatherData(String format, String city) {
        Observable<WeatherData> observable = ApiServiceManager.getWeatherData(format, city);
        Subscription subscribe = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WeatherData>() {
                    @Override
                    public void call(WeatherData weatherData) {
                        if (mWeatherOnListener != null) {
                            mWeatherOnListener.onSuccess(weatherData);
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (mWeatherOnListener != null) {
                            mWeatherOnListener.onFailure(throwable);
                        }
                    }
                });
        return subscribe;
    }

    /**
     * 回调接口
     */
    public interface WeatherOnListener {
        void onSuccess(WeatherData s);

        void onFailure(Throwable e);
    }
}
