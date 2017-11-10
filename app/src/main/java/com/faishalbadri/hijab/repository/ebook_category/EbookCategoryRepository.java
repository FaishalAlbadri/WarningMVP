package com.faishalbadri.hijab.repository.ebook_category;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryRepository implements EbookCategoryDataResource {

  private EbookCategoryDataResource ebookDataResource;

  public EbookCategoryRepository(EbookCategoryDataResource ebookDataResource) {
    this.ebookDataResource = ebookDataResource;
  }

  @Override
  public void getEbookCategoryList(@NonNull EbookCategoryGetCallBack ebookCategoryGetCallBack) {
    ebookDataResource.getEbookCategoryList(ebookCategoryGetCallBack);
  }
}
