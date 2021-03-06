package com.faishalbadri.hijab.repository.search_ebook;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookRepository implements SearchEbookDataResource {

  private SearchEbookDataResource searchEbookDataResource;

  public SearchEbookRepository(
      SearchEbookDataResource searchEbookDataResource) {
    this.searchEbookDataResource = searchEbookDataResource;
  }

  @Override
  public void getSearchEbookResult(String key,
      @NonNull SearchEbookGetCallback searchEbookGetCallback) {
    searchEbookDataResource.getSearchEbookResult(key, searchEbookGetCallback);
  }
}
