package cn.mvp.model;

import rx.Subscription;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 17:10
 * Description:
 */

public interface NewsModel {
    Subscription getNews(String type);
}
