package com.faishalbadri.hijab.aaa_migration_server.ui.search_news;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsContract {

  public interface SearchNewsView {

    void onSuccesSearchNews(List<PojoNews.NewsBean> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

  public interface SearchNewsPresenter extends BasePresenter<SearchNewsView> {

    void getDataSearchNews(String key);
  }

}
