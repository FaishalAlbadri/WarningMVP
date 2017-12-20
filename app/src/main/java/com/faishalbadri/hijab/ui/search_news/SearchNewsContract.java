package com.faishalbadri.hijab.ui.search_news;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsContract {

  public interface SearchNewsView {

    void onSuccesSearchNews(List<PojoNews.IsiBean> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

  public interface SearchNewsPresenter extends BasePresenter<SearchNewsView> {

    void getDataSearchNews(String key);
  }

}
