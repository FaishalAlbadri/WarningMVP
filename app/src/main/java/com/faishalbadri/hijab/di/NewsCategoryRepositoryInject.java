package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.news_category.NewsCategoryRepository;
import com.faishalbadri.hijab.repository.news_category.remote.NewsCategoryDataRemote;


public class NewsCategoryRepositoryInject {
  public static NewsCategoryRepository provideToNewsCategoryInject(Context context){
    return new NewsCategoryRepository(new NewsCategoryDataRemote(context));
  }
}
