package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.category.CategoryRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.category.remote.CategoryDataRemote;


public class CategoryRepositoryInject {

  public static CategoryRepository provideToCategoryInject(Context context) {
    return new CategoryRepository(new CategoryDataRemote(context));
  }
}
