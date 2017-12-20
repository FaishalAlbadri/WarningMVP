package com.faishalbadri.hijab.revamp.di;

import android.content.Context;
import com.faishalbadri.hijab.revamp.repository.category.CategoryRepository;
import com.faishalbadri.hijab.revamp.repository.category.remote.CategoryDataRemote;


public class CategoryRepositoryInject {

  public static CategoryRepository provideToCategoryInject(Context context) {
    return new CategoryRepository(new CategoryDataRemote(context));
  }
}
