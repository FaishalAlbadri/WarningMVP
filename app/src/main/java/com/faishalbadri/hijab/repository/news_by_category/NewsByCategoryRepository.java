package com.faishalbadri.hijab.repository.news_by_category;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryRepository implements NewsByCategoryDataResource {

  NewsByCategoryDataResource newsByCategoryDataResource;

  public NewsByCategoryRepository(
      NewsByCategoryDataResource newsByCategoryDataResource) {
    this.newsByCategoryDataResource = newsByCategoryDataResource;
  }

  @Override
  public void getNewsByCategoryGetDataCallBack(String id,
      @NonNull NewsByCategoryGetDataCallBack newsByCategoryGetDataCallBack) {
    newsByCategoryDataResource.getNewsByCategoryGetDataCallBack(id, newsByCategoryGetDataCallBack);
  }
}
