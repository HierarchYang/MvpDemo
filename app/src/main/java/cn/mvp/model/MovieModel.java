package cn.mvp.model;

import rx.Subscription;

/**
 * <p>Title: cn.mvp.model</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月27日 14:54
 * Description:
 */

public interface MovieModel {

    Subscription getMovies( int start, int count);
}
