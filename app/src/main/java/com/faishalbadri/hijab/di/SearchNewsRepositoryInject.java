package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.search_news_.SearchNewsRepository;
import com.faishalbadri.hijab.repository.search_news_.remote.SearchNewsDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsRepositoryInject {

  public static SearchNewsRepository provideToSearchNewsRepository(Context context) {
    return new SearchNewsRepository(new SearchNewsDataRemote(context));
  }

}
