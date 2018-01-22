package com.faishalbadri.hijab.ui.news.fragment.news;

import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.repository.news.NewsDataResource.NewsGetCallback;
import com.faishalbadri.hijab.repository.news.NewsDataResource.SliderGetCallback;
import com.faishalbadri.hijab.repository.news.NewsRepository;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPresenter implements NewsContract.newsPresenter {

  private NewsContract.newsView newsView;
  private NewsRepository newsRepository;

  public NewsPresenter(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
  }

  @Override
  public void onAttachView(NewsContract.newsView view) {
    this.newsView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataNews(int PAGE) {
    newsRepository.getNewsResult(PAGE, new NewsGetCallback() {
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
      public void onSuccesSlider(List<NewsBean> dataSlider, String msg) {
        newsView.onSuccesSlider(dataSlider, msg);
      }

      @Override
      public void onErrorSlider(String msg) {
        newsView.onErrorSlider(msg);
      }
    });
  }
}
