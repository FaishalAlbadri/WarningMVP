package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.NewsDataResource.NewsGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.NewsDataResource.SliderGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.NewsRepository;
import com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news.NewsContract.newsView;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPresenter implements NewsContract.newsPresenter {

  NewsContract.newsView newsView;
  NewsRepository newsRepository;

  public NewsPresenter(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  @Override
  public void onAttachView(newsView view) {
    this.newsView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNews() {
    newsRepository.getNewsResult(new NewsGetCallback() {
      @Override
      public void onSuccesNews(List<NewsBean> data, String msg) {
        newsView.onSuccesNews(data, msg);
      }

      @Override
      public void onErrorNews(String msg) {
        newsView.onErrorNews(msg);
      }

    });
  }

  @Override
  public void getDataSlider() {
    newsRepository.getSliderResult(new SliderGetCallback() {
      @Override
      public void onSuccesSlider(List<PojoNews.NewsBean> dataSlider, String msg) {
        newsView.onSuccesSlider(dataSlider, msg);
      }

      @Override
      public void onErrorSlider(String msg) {
        newsView.onErrorSlider(msg);
      }
    });
  }
}
