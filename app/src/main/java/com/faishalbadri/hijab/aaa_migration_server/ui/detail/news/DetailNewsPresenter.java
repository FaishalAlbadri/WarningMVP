package com.faishalbadri.hijab.aaa_migration_server.ui.detail.news;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.aaa_migration_server.repository.detail_news_related.DetailNewsDataResource.DetailNewsPopularGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.detail_news_related.DetailNewsRepository;
import com.faishalbadri.hijab.aaa_migration_server.ui.detail.news.DetailNewsContract.DetailNewsView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsPresenter implements DetailNewsContract.DetailNewsPresenter {

  DetailNewsView detailNewsView;
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
  public void getData(String id_isi) {
    detailNewsRepository.getDetailNewsPopularResult(id_isi, new DetailNewsPopularGetCallback
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

}
