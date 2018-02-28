package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.ebook_.EbookRepository;
import com.faishalbadri.hijab.repository.ebook_.remote.EbookDataRemote;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookRepositoryInject {

  public static EbookRepository provideToEbookRepositories(Context context) {
    return new EbookRepository(new EbookDataRemote(context));
  }
}
