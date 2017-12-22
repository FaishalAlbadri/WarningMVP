package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news_popular;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.aaa_migration_server.repository.news_popular.NewsPopularDataResource.NewsPopularGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.news_popular.NewsPopularRepository;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularPresenter implements NewsPopularContract.newsPopularPresenter {

  NewsPopularContract.newsPopularView newsPopularView;
  NewsPopularRepository newsPopularRepository;

  public NewsPopularPresenter(NewsPopularRepository newsPopularRepository) {
    this.newsPopularRepository = newsPopularRepository;
  }

  @Override
  public void onAttachView(NewsPopularContract.newsPopularView view) {
    this.newsPopularView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNewsPopular() {
    newsPopularRepository.getNewsPopularResult(new NewsPopularGetCallback() {
      @Override
      public void onSuccesNewsPopular(List<NewsBean> data, String msg) {
        newsPopularView.onSuccesNewsPopular(data, msg);
      }

      @Override
      public void onErrorNewsPopular(String msg) {
        newsPopularView.onErrorNewsPopular(msg);
      }
    });
  }
}
