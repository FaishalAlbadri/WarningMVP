package com.faishalbadri.hijab.ui.search_event;

import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.repository.search_event.SearchEventDataResource.SearchEventGetCallback;
import com.faishalbadri.hijab.repository.search_event.SearchEventRepository;
import com.faishalbadri.hijab.ui.search_event.SearchEventContract.SearchEventView;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventPresenter implements SearchEventContract.SearchEventPresenter {

  private SearchEventContract.SearchEventView searchEventView;
  private SearchEventRepository searchEventRepository;

  public SearchEventPresenter(
      SearchEventRepository searchEventRepository) {
    this.searchEventRepository = searchEventRepository;
  }

  @Override
  public void onAttachView(SearchEventView view) {
    this.searchEventView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSearchEvent(String key) {
    searchEventRepository.getSearchEventResult(key, new SearchEventGetCallback() {
      @Override
      public void onSuccesSearchEvent(List<EventItem> data, String msg) {
        searchEventView.onSuccesSearchEvent(data, msg);
      }

      @Override
      public void onWrongSearchEvent(String msg) {
        searchEventView.onWrongSearchEvent(msg);
      }

      @Override
      public void onErrorSearchEvent(String msg) {
        searchEventView.onErrorSearchEvent(msg);
      }
    });
  }
}
