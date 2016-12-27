package cn.mvp.presenter;

import cn.mvp.bean.MovieBean;
import cn.mvp.model.MovieModel;
import cn.mvp.model.MovieModelImpl;
import cn.mvp.ui.MovieView;

/**
 * <p>Title: cn.mvp.presenter</p>
 *
 * @author : Huawen
 * @version 1.0
 * @date : 2016年12月27日 15:03
 * Description:
 */

public class MoviePresenterImpl extends BasePresenter implements MoviePresenter, MovieModelImpl.OnMoviesListener {
    private static final String TAG = "MoviePresenterImpl";
    private MovieView mMovieView;
    private MovieModel mMovieModel;

    public MoviePresenterImpl(MovieView movieView) {
        this.mMovieView = movieView;
        mMovieModel = new MovieModelImpl(this);
    }

    @Override
    public void getMovies(int start, int count) {
        mMovieView.showProgress();
        addSubscription(mMovieModel.getMovies(start, count));
    }

    @Override
    public void onSuccess(MovieBean movieBean) {
        mMovieView.hideProgress();
        mMovieView.getMovies(movieBean);
    }

    @Override
    public void onFailure(Throwable throwable) {
        mMovieView.hideProgress();
    }
}
