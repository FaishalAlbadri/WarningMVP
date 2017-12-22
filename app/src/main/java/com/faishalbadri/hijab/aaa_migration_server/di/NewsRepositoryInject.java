package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.NewsRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.news.remote.NewsDataRemote;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsRepositoryInject {

  public static NewsRepository provideToNewsRepository(Context context) {
    return new NewsRepository(new NewsDataRemote(context));
  }
}
