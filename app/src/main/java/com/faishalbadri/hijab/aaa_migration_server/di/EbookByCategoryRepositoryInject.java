package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryRepository;
import com.faishalbadri.hijab.repository.ebook_by_category.remote.EbookByCategoryDataRemote;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryRepositoryInject {

  public static EbookByCategoryRepository provideToEbookCategoryRepositories(Context context) {
    return new EbookByCategoryRepository(new EbookByCategoryDataRemote(context));
  }
}
