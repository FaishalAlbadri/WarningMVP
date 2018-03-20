package com.faishalbadri.hijab.ui.news.fragment.news;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.news.NewsItem;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsContract {

  public interface newsView {

    void onSuccesNews(List<NewsItem> data, String msg);

    void onErrorNews(String msg);

    void onSuccesSlider(List<NewsItem> dataSlider, String msg);

    void onErrorSlider(String msg);

  }

  public interface newsPresenter extends BasePresenter<NewsContract.newsView> {

    void getDataNews(int PAGE);

    void getDataSlider();

  }

}
