package cn.mvp.presenter;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月26日 17:16
 * Description:
 */

public abstract class NewsPresenter extends BasePresenter {
    /**
     * @param type
     */
    public abstract void getNews(String type);
}
