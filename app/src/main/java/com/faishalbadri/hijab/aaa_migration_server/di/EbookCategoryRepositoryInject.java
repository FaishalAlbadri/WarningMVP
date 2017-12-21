package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.ebook_category.EbookCategoryRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.ebook_category.remote.EbookCategoryDataRemote;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryRepositoryInject {

  public static EbookCategoryRepository provideToEbookCategoryRepositories(Context context) {
    return new EbookCategoryRepository(new EbookCategoryDataRemote(context));
  }
}
