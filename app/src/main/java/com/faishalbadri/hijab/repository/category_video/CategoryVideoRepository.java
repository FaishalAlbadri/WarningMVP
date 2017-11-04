package com.faishalbadri.hijab.repository.category_video;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoRepository implements CategoryVideoDataResource {

  CategoryVideoDataResource categoryVideoDataResource;

  public CategoryVideoRepository(
      CategoryVideoDataResource newsCategoryDataResource) {
    this.categoryVideoDataResource = newsCategoryDataResource;
  }

  @Override
  public void getCategoryVideoList(@NonNull CategoryVideoGetCallBack categoryVideoGetCallBack) {
    categoryVideoDataResource.getCategoryVideoList(categoryVideoGetCallBack);
  }
}
