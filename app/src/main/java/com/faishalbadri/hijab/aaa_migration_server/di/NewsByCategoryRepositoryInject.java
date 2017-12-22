package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.news_by_category.NewsByCategoryRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.news_by_category.remote.NewsByCategoryDataRemote;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryRepositoryInject {

  public static NewsByCategoryRepository provideToNewsByCategoryRepository(Context context) {
    return new NewsByCategoryRepository(new NewsByCategoryDataRemote(context));
  }
}
