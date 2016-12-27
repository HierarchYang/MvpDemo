package cn.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import cn.mvp.bean.MovieBean;
import cn.mvp.presenter.MoviePresenter;
import cn.mvp.presenter.MoviePresenterImpl;
import cn.mvp.ui.MovieView;

public class MovieActivity extends AppCompatActivity implements MovieView {
    private MoviePresenter mMoviePresenter;
    private static final String TAG = "MovieActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        mMoviePresenter = new MoviePresenterImpl(this);
        mMoviePresenter.getMovies(0, 10);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void getMovies(MovieBean movieBean) {
        List<MovieBean.SubjectsBean> subjects = movieBean.getSubjects();
        for (MovieBean.SubjectsBean subjectsBean:subjects) {
            Log.i(TAG,subjectsBean.getTitle());
        }
    }
}
