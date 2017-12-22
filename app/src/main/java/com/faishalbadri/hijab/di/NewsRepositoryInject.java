package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.news.NewsRepository;
import com.faishalbadri.hijab.repository.news.remote.NewsDataRemote;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsRepositoryInject {

  public static NewsRepository provideToNewsRepository(Context context) {
    return new NewsRepository(new NewsDataRemote(context));
  }
}
