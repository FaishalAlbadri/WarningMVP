package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.search_video_.SearchVideoRepository;
import com.faishalbadri.hijab.repository.search_video_.remote.SearchVideoDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoRepositoryInject {

  public static SearchVideoRepository provideToSearchVideoRepository(Context context) {
    return new SearchVideoRepository(new SearchVideoDataRemote(context));
  }

}
