package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.category.CategoryRepository;
import com.faishalbadri.hijab.repository.category.remote.CategoryDataRemote;


public class CategoryRepositoryInject {
  public static CategoryRepository provideToCategoryInject(Context context){
    return new CategoryRepository(new CategoryDataRemote(context));
  }
}
