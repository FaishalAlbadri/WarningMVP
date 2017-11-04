package com.faishalbadri.hijab.repository.news_category;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryRepository implements NewsCategoryDataResource{

  NewsCategoryDataResource newsCategoryDataResource;

  public NewsCategoryRepository(
      NewsCategoryDataResource newsCategoryDataResource) {
    this.newsCategoryDataResource = newsCategoryDataResource;
  }

  @Override
  public void getNewsCategoryResult(@NonNull NewsCategoryGetCallback newsCategoryGetCallback) {
    newsCategoryDataResource.getNewsCategoryResult(newsCategoryGetCallback);
  }
}
