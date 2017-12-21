package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.search_video.SearchVideoRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.search_video.remote.SearchVideoDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoRepositoryInject {

  public static SearchVideoRepository provideToSearchVideoRepository(Context context) {
    return new SearchVideoRepository(new SearchVideoDataRemote(context));
  }

}
