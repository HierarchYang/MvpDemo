package cn.mvp.retrofit;

import cn.mvp.bean.MovieBean;
import cn.mvp.bean.NewsBean;
import cn.mvp.bean.WeatherData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * <p>Title: cn.mvp.retrofit</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:45
 * Description:
 */

public interface ApiService {
    /**
     * 获取数据
     *
     * @param cityname
     * @param key
     * @return
     */
    @GET("/weather/index")
    Observable<WeatherData> getWeatherData(@Query("format") String format,
                                           @Query("cityname") String cityname,
                                           @Query("key") String key);

    @GET("toutiao/index")
    Observable<NewsBean> getNews(@Query("key") String key, @Query("type") String type);

    /**
     * 获取movie的数据
     *
     * @param start
     * @param count
     * @return
     */
    @GET("v2/movie/top250")
    Observable<MovieBean> getMovies(@Query("start") int start, @Query("count") int count);

}
