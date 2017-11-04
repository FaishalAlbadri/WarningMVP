package com.faishalbadri.hijab.repository.category_video;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoRepository implements CategoryVideoDataResource {

  private CategoryVideoDataResource categoryVideoDataResource;

  public CategoryVideoRepository(CategoryVideoDataResource categoryVideoDataResource) {
    this.categoryVideoDataResource = categoryVideoDataResource;
  }

  @Override
  public void getCategoryVideoList(@NonNull CategoryVideoGetCallBack CategoryVideoGetCallBack) {
    categoryVideoDataResource.getCategoryVideoList(CategoryVideoGetCallBack);
  }
}
