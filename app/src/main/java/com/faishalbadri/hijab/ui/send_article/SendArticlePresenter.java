package com.faishalbadri.hijab.ui.send_article;

import com.faishalbadri.hijab.repository.send_article_delete.SendArticleDataResource.uploadFile;
import com.faishalbadri.hijab.repository.send_article_delete.SendArticleRepository;
import com.faishalbadri.hijab.ui.send_article.SendArticleContract.uploadFileView;
import com.faishalbadri.hijab.util.ActivityUtil;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticlePresenter implements SendArticleContract.uploadFilePresenter {

  private SendArticleRepository sendArticleRepository;
  private SendArticleContract.uploadFileView uploadFileView;

  public SendArticlePresenter(
      SendArticleRepository sendArticleRepository) {
    this.sendArticleRepository = sendArticleRepository;
  }

  @Override
  public void onAttachView(uploadFileView view) {
    this.uploadFileView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getUploadFile(String path) {
    sendArticleRepository.getEditImageResult(path, new uploadFile() {
      @Override
      public void onSuccess() {
        uploadFileView.onSuccessUploadFile();
      }

      @Override
      public void onError(String msg) {
        uploadFileView.onErrorUploadFile(msg);
      }
    });
  }
}
