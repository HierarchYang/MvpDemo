package cn.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.mvp.bean.WeatherData;
import cn.mvp.presenter.WeatherPresenter;
import cn.mvp.presenter.WeatherPresenterImpl;
import cn.mvp.ui.WeatherView;

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    private WeatherPresenter mWeatherPresenter;
    private static final String TAG = "WeatherActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        mWeatherPresenter = new WeatherPresenterImpl(this);
        mWeatherPresenter.getWeatherData("2", "苏州");
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {
        mWeatherPresenter.onUnsubscribe();
    }

    @Override
    public void loadWeather(WeatherData weatherData) {
        Log.i(TAG, "------->>" + weatherData.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWeatherPresenter.onUnsubscribe();
    }
}
