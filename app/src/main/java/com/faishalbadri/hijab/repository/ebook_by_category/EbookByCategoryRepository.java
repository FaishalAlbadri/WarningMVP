package com.faishalbadri.hijab.repository.ebook_by_category;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryRepository implements EbookByCategoryDataResource {

  private EbookByCategoryDataResource ebookByCategoryDataResource;

  public EbookByCategoryRepository(EbookByCategoryDataResource ebookByCategoryDataResource) {
    this.ebookByCategoryDataResource = ebookByCategoryDataResource;
  }

  @Override
  public void getByCategoryGetDataCallBack(String id,
      @NonNull EbookByCategoryDataCallBack ebookByCategoryDataCallBack) {
    ebookByCategoryDataResource.getByCategoryGetDataCallBack(id, ebookByCategoryDataCallBack);
  }
}
