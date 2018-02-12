package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.send_article.SendArticleRepository;
import com.faishalbadri.hijab.repository.send_article.remote.SendArticleDataRemote;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticleRepositoryInject {

  public static SendArticleRepository provideToSendArticleRepository(Context context) {
    return new SendArticleRepository(new SendArticleDataRemote(context));
  }

}
