package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.news_popular_.NewsPopularRepository;
import com.faishalbadri.hijab.repository.news_popular_.remote.NewsPopularDataRemote;

/**
 * Created by faishal on 11/5/17.
 */

public class NewsPopularRepositoryInject {

  public static NewsPopularRepository provideToNewsPopularRepository(Context context) {
    return new NewsPopularRepository(new NewsPopularDataRemote(context));
  }
}
