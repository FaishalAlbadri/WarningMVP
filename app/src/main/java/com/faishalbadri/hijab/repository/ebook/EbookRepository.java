package com.faishalbadri.hijab.repository.ebook;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookRepository implements EbookDataResource {

  private EbookDataResource ebookDataResource;

  public EbookRepository(EbookDataResource ebookDataResource) {
    this.ebookDataResource = ebookDataResource;
  }

  @Override
  public void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack) {
    ebookDataResource.getEbookList(ebookGetCallBack);
  }
}
