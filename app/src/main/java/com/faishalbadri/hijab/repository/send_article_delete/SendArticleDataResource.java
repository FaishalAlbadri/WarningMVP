package com.faishalbadri.hijab.repository.send_article_delete;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.util.ActivityUtil;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public interface SendArticleDataResource {

  void getEditImageResult(String path,
      @NonNull SendArticleDataResource.uploadFile uploadFile);

  interface uploadFile {

    void onSuccess();

    void onError(String msg);

  }
}
