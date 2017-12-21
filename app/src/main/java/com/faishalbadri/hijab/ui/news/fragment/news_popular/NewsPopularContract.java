package com.faishalbadri.hijab.ui.news.fragment.news_popular;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularContract {

  public interface newsPopularView {

    void onSuccesNewsPopular(List<PojoNews.IsiBean> data, String msg);

    void onErrorNewsPopular(String msg);

  }

  public interface newsPopularPresenter extends BasePresenter<NewsPopularContract.newsPopularView> {

    void getDataNewsPopular();

  }

}
