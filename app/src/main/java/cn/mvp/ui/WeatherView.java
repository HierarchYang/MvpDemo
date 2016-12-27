package cn.mvp.ui;

import cn.mvp.bean.WeatherData;

/**
 * <p>Title: cn.mvp.ui</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:41
 * Description:
 */

public interface WeatherView {
    void showProgress();

    void hideProgress();

    void loadWeather(WeatherData weatherData);
}
