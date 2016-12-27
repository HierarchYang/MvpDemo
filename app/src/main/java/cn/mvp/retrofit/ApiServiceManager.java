package cn.mvp.retrofit;

import cn.mvp.bean.MovieBean;
import cn.mvp.bean.NewsBean;
import cn.mvp.bean.WeatherData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * <p>Title: cn.mvp.retrofit</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 16:46
 * Description:
 */

public class ApiServiceManager {
    private static final String ENDPOINT = "http://v.juhe.cn";

    private static final Retrofit sRetrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 使用RxJava作为回调适配器
            .build();

    private static final ApiService apiManager = sRetrofit.create(ApiService.class);

    public static Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    /**
     * 获取天气数据
     *
     * @param city
     * @return
     */
    public static Observable<WeatherData> getWeatherData(String format, String city) {
        return apiManager.getWeatherData(format, city, "ad1d20bebafe0668502c8eea5ddd0333");
    }

    public static Observable<NewsBean> getNews(String type) {
        return apiManager.getNews("8c3d1deadf612e0641929df03ed2324c", type);
    }

    /**
     * 获取movie，
     *
     * @param baseUrl
     * @param start
     * @param count
     * @return
     */

    public static Observable<MovieBean> getMovies(String baseUrl, int start, int count) {
        Retrofit retrofit = createRetrofit(baseUrl);
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MovieBean> movieBeanObservable = apiService.getMovies(start, count);
        return movieBeanObservable;
    }
}
