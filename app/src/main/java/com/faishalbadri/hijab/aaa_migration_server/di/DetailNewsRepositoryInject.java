package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.detail_news_related.DetailNewsRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.detail_news_related.remote.DetailNewsDataRemote;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsRepositoryInject {

  public static DetailNewsRepository provideToDetailNewsInject(Context context) {
    return new DetailNewsRepository(new DetailNewsDataRemote(context));
  }

}
