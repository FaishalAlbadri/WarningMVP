package com.faishalbadri.hijab.repository.search_news;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsRepository implements SearchNewsDataResource {

  private SearchNewsDataResource searchNewsDataResource;

  public SearchNewsRepository(
      SearchNewsDataResource searchNewsDataResource) {
    this.searchNewsDataResource = searchNewsDataResource;
  }

  @Override
  public void getSearchNewsResult(String key,
      @NonNull SearchNewsGetCallback searchNewsGetCallback) {
    searchNewsDataResource.getSearchNewsResult(key, searchNewsGetCallback);
  }
}
