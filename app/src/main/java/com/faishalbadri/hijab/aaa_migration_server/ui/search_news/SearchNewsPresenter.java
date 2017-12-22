package com.faishalbadri.hijab.aaa_migration_server.ui.search_news;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.aaa_migration_server.repository.search_news.SearchNewsDataResource.SearchNewsGetCallback;
import com.faishalbadri.hijab.aaa_migration_server.repository.search_news.SearchNewsRepository;
import com.faishalbadri.hijab.aaa_migration_server.ui.search_news.SearchNewsContract.SearchNewsView;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsPresenter implements SearchNewsContract.SearchNewsPresenter {

  SearchNewsContract.SearchNewsView searchNewsView;
  SearchNewsRepository searchNewsRepository;

  public SearchNewsPresenter(
      SearchNewsRepository searchNewsRepository) {
    this.searchNewsRepository = searchNewsRepository;
  }

  @Override
  public void onAttachView(SearchNewsView view) {
    this.searchNewsView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSearchNews(String key) {
    searchNewsRepository.getSearchNewsResult(key, new SearchNewsGetCallback() {
      @Override
      public void onSuccesSearchNews(List<NewsBean> data, String msg) {
        searchNewsView.onSuccesSearchNews(data, msg);
      }

      @Override
      public void onWrongSearchNews(String msg) {
        searchNewsView.onWrongSearchNews(msg);
      }

      @Override
      public void onErrorSearchNews(String msg) {
        searchNewsView.onErrorSearchNews(msg);
      }
    });
  }
}
