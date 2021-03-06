package com.faishalbadri.hijab.repository.category;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class CategoryRepository implements CategoryDataResource {

  private CategoryDataResource categoryDataResource;

  public CategoryRepository(
      CategoryDataResource categoryDataResource) {
    this.categoryDataResource = categoryDataResource;
  }

  @Override
  public void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback) {
    categoryDataResource.getCategoryResult(categoryGetCallback);
  }
}
