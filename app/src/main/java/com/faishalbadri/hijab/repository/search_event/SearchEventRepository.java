package com.faishalbadri.hijab.repository.search_event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.repository.search_event.remote.SearchEventDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventRepository implements SearchEventDataResource {

  SearchEventDataResource searchEventDataResource;

  public SearchEventRepository(
      SearchEventDataResource searchEventDataResource) {
    this.searchEventDataResource = searchEventDataResource;
  }

  @Override
  public void getSearchEventResult(String key,
      @NonNull SearchEventGetCallback searchEventGetCallback) {
    searchEventDataResource.getSearchEventResult(key, searchEventGetCallback);
  }
}
