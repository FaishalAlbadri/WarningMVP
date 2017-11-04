package com.faishalbadri.hijab.ui.news.fragment.news;

import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.repository.news.NewsDataResource.NewsGetCallback;
import com.faishalbadri.hijab.repository.news.NewsRepository;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsContract.newsView;
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
      public void onSuccesNews(List<IsiBean> data, String msg) {
        newsView.onSuccesNews(data, msg);
      }

      @Override
      public void onErrorNews(String msg) {
        newsView.onErrorNews(msg);
      }
    });
  }
}
