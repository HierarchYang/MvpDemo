package cn.mvp.presenter;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:51
 * Description:
 */

public abstract class WeatherPresenter extends BasePresenter{
    /**
     * 获取天气信息
     * @param format
     * @param city
     */
    public abstract void getWeatherData(String format, String city);
}
