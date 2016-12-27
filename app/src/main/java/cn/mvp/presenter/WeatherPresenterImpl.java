package cn.mvp.presenter;

import android.util.Log;

import cn.mvp.bean.WeatherData;
import cn.mvp.model.WeatherModel;
import cn.mvp.model.WeatherModelImpl;
import cn.mvp.ui.WeatherView;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:51
 * Description:
 */

public class WeatherPresenterImpl extends WeatherPresenter implements WeatherModelImpl.WeatherOnListener {
    private WeatherModel mWeatherModel;
    private WeatherView mWeatherView;
    private static final String TAG = "WeatherPresenterImpl";

    public WeatherPresenterImpl(WeatherView mWeatherView) {
        this.mWeatherModel = new WeatherModelImpl(this);
        this.mWeatherView = mWeatherView;
    }

    @Override
    public void getWeatherData(String format, String city) {
        mWeatherView.showProgress();
        addSubscription(mWeatherModel.getWeatherData(format, city));
    }

    @Override
    public void onSuccess(WeatherData s) {
        mWeatherView.loadWeather(s);
        mWeatherView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mWeatherView.hideProgress();
        Log.i(TAG, "onFailure");
    }
}
