package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.search_event.SearchEventRepository;
import com.faishalbadri.hijab.revamp.repository.search_event.remote.SearchEventDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventRepositoryInject {

  public static SearchEventRepository provideToSearchEventRepository(Context context) {
    return new SearchEventRepository(new SearchEventDataRemote(context));
  }
}
