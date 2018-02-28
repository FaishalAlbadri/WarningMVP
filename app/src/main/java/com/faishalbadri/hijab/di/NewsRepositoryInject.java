package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.news_.NewsRepository;
import com.faishalbadri.hijab.repository.news_.remote.NewsDataRemote;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsRepositoryInject {

  public static NewsRepository provideToNewsRepository(Context context) {
    return new NewsRepository(new NewsDataRemote(context));
  }
}
