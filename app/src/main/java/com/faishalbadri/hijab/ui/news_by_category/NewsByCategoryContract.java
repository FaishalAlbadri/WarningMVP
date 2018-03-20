package com.faishalbadri.hijab.ui.news_by_category;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.news.NewsItem;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryContract {

  public interface NewsByCategoryView {

    void onSuccesNewsByCategory(List<NewsItem> data, String msg);

    void onErrorNewsByCategory(String msg);
  }

  public interface NewsByCategoryPresenter extends
      BasePresenter<NewsByCategoryContract.NewsByCategoryView> {

    void getDataNewsByCategory(String id);
  }

}
