package cn.mvp.ui;

import cn.mvp.bean.MovieBean;

/**
 * <p>Title: cn.mvp.ui</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月27日 15:02
 * Description:
 */

public interface MovieView {
    void showProgress();

    void hideProgress();


    void getMovies(MovieBean movieBean);
}
