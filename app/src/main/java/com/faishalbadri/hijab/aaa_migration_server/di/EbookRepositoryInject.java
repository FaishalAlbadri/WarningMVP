package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.ebook.EbookRepository;
import com.faishalbadri.hijab.repository.ebook.remote.EbookDataRemote;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookRepositoryInject {

  public static EbookRepository provideToEbookRepositories(Context context) {
    return new EbookRepository(new EbookDataRemote(context));
  }
}
