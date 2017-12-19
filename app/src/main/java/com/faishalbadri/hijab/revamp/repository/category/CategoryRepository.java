package com.faishalbadri.hijab.revamp.repository.category;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class CategoryRepository implements CategoryDataResource {

  CategoryDataResource categoryDataResource;

  public CategoryRepository(
      CategoryDataResource categoryDataResource) {
    this.categoryDataResource = categoryDataResource;
  }

  @Override
  public void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback) {
    categoryDataResource.getCategoryResult(categoryGetCallback);
  }
}
