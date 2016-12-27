package cn.mvp.model;

import rx.Subscription;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:52
 * Description:
 */

public interface WeatherModel {
    /**
     * 获取天气信息
     *
     * @param format
     * @param city
     */
    Subscription getWeatherData(String format, String city);

}
