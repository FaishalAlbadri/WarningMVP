package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.detail_news_related_.DetailNewsRepository;
import com.faishalbadri.hijab.repository.detail_news_related_.remote.DetailNewsDataRemote;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsRepositoryInject {

  public static DetailNewsRepository provideToDetailNewsInject(Context context) {
    return new DetailNewsRepository(new DetailNewsDataRemote(context));
  }

}
