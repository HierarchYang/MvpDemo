package cn.mvp.ui;

import cn.mvp.bean.NewsBean;

/**
 * <p>Title: cn.mvp.ui</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 17:18
 * Description:
 */

public interface NewsView {
    void showProgress();

    void hideProgress();

    void getNews(NewsBean newsBean);
}
