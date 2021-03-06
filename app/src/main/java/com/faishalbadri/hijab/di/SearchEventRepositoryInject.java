package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.search_event.SearchEventRepository;
import com.faishalbadri.hijab.repository.search_event.remote.SearchEventDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventRepositoryInject {

  public static SearchEventRepository provideToSearchEventRepository(Context context) {
    return new SearchEventRepository(new SearchEventDataRemote(context));
  }
}
