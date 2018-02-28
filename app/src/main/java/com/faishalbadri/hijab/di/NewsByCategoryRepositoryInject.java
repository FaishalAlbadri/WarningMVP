package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.news_by_category_.NewsByCategoryRepository;
import com.faishalbadri.hijab.repository.news_by_category_.remote.NewsByCategoryDataRemote;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryRepositoryInject {

  public static NewsByCategoryRepository provideToNewsByCategoryRepository(Context context) {
    return new NewsByCategoryRepository(new NewsByCategoryDataRemote(context));
  }
}
