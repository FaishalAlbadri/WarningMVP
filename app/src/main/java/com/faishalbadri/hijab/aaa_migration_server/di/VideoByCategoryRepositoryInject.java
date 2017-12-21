package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.video_by_category.VideoByCategoryRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.video_by_category.remote.VideoByCategoryRemote;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoByCategoryRepositoryInject {

  public static VideoByCategoryRepository provideToVideoByCategoryRepository(Context context) {
    return new VideoByCategoryRepository(new VideoByCategoryRemote(context));
  }
}
