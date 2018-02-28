package com.faishalbadri.hijab.repository.send_article_delete;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticleRepository implements SendArticleDataResource{

  private SendArticleDataResource sendArticleDataResource;

  public SendArticleRepository(
      SendArticleDataResource sendArticleDataResource) {
    this.sendArticleDataResource = sendArticleDataResource;
  }

  @Override
  public void getEditImageResult(String path, @NonNull uploadFile uploadFile) {
    sendArticleDataResource.getEditImageResult(path, uploadFile);
  }
}
