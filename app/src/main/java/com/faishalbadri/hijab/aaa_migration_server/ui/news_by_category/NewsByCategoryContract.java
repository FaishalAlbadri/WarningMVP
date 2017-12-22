package com.faishalbadri.hijab.aaa_migration_server.ui.news_by_category;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryContract {

  public interface NewsByCategoryView {

    void onSuccesNewsByCategory(List<PojoNews.NewsBean> data, String msg);

    void onErrorNewsByCategory(String msg);
  }

  public interface NewsByCategoryPresenter extends
      BasePresenter<NewsByCategoryContract.NewsByCategoryView> {

    void getDataNewsByCategory(String id);
  }

}
