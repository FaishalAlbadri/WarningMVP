package com.faishalbadri.hijab.ui.news.fragment.news_popular;

import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.repository.news.NewsDataResource.NewsGetCallback;
import com.faishalbadri.hijab.repository.news.NewsRepository;
import com.faishalbadri.hijab.repository.news_popular.NewsPopularDataResource.NewsPopularGetCallback;
import com.faishalbadri.hijab.repository.news_popular.NewsPopularRepository;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsContract.newsView;
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
      public void onSuccesNewsPopular(List<IsiBean> data, String msg) {
        newsPopularView.onSuccesNewsPopular(data, msg);
      }

      @Override
      public void onErrorNewsPopular(String msg) {
        newsPopularView.onErrorNewsPopular(msg);
      }
    });
  }
}
