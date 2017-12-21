package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.search_news.SearchNewsRepository;
import com.faishalbadri.hijab.repository.search_news.remote.SearchNewsDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsRepositoryInject {

  public static SearchNewsRepository provideToSearchNewsRepository(Context context) {
    return new SearchNewsRepository(new SearchNewsDataRemote(context));
  }

}
