package cn.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import cn.mvp.bean.NewsBean;
import cn.mvp.presenter.NewsPresenter;
import cn.mvp.presenter.NewsPresenterImpl;
import cn.mvp.ui.NewsView;

public class NewsActivity extends AppCompatActivity implements NewsView {
    private static final String TAG = "NewsActivity";
    private NewsPresenter mNewsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mNewsPresenter = new NewsPresenterImpl(this);
        mNewsPresenter.getNews("top");
    }

    @Override
    public void showProgress() {
    //http://blog.csdn.net/qq137722697/article/details/52212348
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void getNews(NewsBean newsBean) {
        NewsBean.ResultBean resultBean = newsBean.getResult();
        List<NewsBean.ResultBean.DataBean> data = resultBean.getData();
        for (NewsBean.ResultBean.DataBean databean : data) {
            Log.i(TAG, databean.getTitle());
        }
    }
}
