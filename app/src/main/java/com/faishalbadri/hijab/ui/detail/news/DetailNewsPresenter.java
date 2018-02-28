package com.faishalbadri.hijab.ui.detail.news;

import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.repository.detail_news_related_.DetailNewsDataResource.DetailNewsPopularGetCallback;
import com.faishalbadri.hijab.repository.detail_news_related_.DetailNewsDataResource.viewGetCallback;
import com.faishalbadri.hijab.repository.detail_news_related_.DetailNewsRepository;
import com.faishalbadri.hijab.ui.detail.news.DetailNewsContract.DetailNewsView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsPresenter implements DetailNewsContract.DetailNewsPresenter {

  private DetailNewsView detailNewsView;
  private DetailNewsRepository detailNewsRepository;

  public DetailNewsPresenter(DetailNewsRepository detailNewsRepository) {
    this.detailNewsRepository = detailNewsRepository;
  }

  @Override
  public void onAttachView(DetailNewsView view) {
    detailNewsView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData(String id_content) {
    detailNewsRepository.getDetailNewsPopularResult(id_content, new DetailNewsPopularGetCallback
        () {
      @Override
      public void onSuccesDetailNewsPopular(List<NewsBean> data, String msg) {
        detailNewsView.onSuccessDetailNews(data, msg);
      }

      @Override
      public void onErrorDetailNewsPopular(String msg) {
        detailNewsView.onError(msg);
      }
    });
  }

  @Override
  public void getView(String id_news) {
    detailNewsRepository.getViewResult(id_news, new viewGetCallback() {

      @Override
      public void onSuccesView(List<NewsBean> data, String msg) {
        detailNewsView.onSuccesView(data, msg);
      }

      @Override
      public void onError(String msg) {
        detailNewsView.onError(msg);
      }
    });
  }

}
