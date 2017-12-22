package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news_popular;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularContract {

  public interface newsPopularView {

    void onSuccesNewsPopular(List<PojoNews.NewsBean> data, String msg);

    void onErrorNewsPopular(String msg);

  }

  public interface newsPopularPresenter extends BasePresenter<NewsPopularContract.newsPopularView> {

    void getDataNewsPopular();

  }

}
