package com.faishalbadri.hijab.aaa_migration_server.repository.search_video;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoRepository implements SearchVideoDataResource {

  SearchVideoDataResource searchVideoDataResource;

  public SearchVideoRepository(
      SearchVideoDataResource searchVideoDataResource) {
    this.searchVideoDataResource = searchVideoDataResource;
  }

  @Override
  public void getSearchVideoResult(String key,
      @NonNull SearchVideoGetCallback searchVideoGetCallback) {
    searchVideoDataResource.getSearchVideoResult(key, searchVideoGetCallback);
  }
}
