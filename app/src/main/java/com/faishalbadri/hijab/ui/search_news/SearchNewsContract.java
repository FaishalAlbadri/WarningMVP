package com.faishalbadri.hijab.ui.search_news;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.news.NewsItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsContract {

  public interface SearchNewsView {

    void onSuccesSearchNews(List<NewsItem> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

  public interface SearchNewsPresenter extends BasePresenter<SearchNewsView> {

    void getDataSearchNews(String key);
  }

}
