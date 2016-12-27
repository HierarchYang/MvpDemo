package cn.mvp.common;

/**
 * <p>Title: cn.mvp.newmvp.common</p>
 * presenter的基类接口，提供给子类的引用
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月27日 13:54
 * Description:
 */

public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);

    void detachView();
}
