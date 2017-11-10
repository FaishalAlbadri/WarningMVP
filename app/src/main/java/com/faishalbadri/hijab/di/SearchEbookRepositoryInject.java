package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.search_ebook.SearchEbookRepository;
import com.faishalbadri.hijab.repository.search_ebook.remote.SearchEbookDataRemote;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookRepositoryInject {
  public static SearchEbookRepository provideToSearchEbookRepository(Context context){
    return new SearchEbookRepository(new SearchEbookDataRemote(context));
  }
}
