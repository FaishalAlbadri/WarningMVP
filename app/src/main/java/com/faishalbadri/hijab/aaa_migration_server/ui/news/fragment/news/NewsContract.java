package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsContract {

  public interface newsView {

    void onSuccesNews(List<PojoNews.NewsBean> data, String msg);

    void onErrorNews(String msg);

    void onSuccesSlider(List<PojoNews.NewsBean> dataSlider, String msg);

    void onErrorSlider(String msg);

  }

  public interface newsPresenter extends BasePresenter<NewsContract.newsView> {

    void getDataNews();

    void getDataSlider();

  }

}
