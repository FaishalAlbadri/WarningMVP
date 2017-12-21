package com.faishalbadri.hijab.aaa_migration_server.di;

import android.content.Context;
import com.faishalbadri.hijab.aaa_migration_server.repository.video.VideoRepository;
import com.faishalbadri.hijab.aaa_migration_server.repository.video.remote.VideoDataRemote;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoRepositoryInject {

  public static VideoRepository provideToCategoryVideoRepositories(Context context) {
    return new VideoRepository(new VideoDataRemote(context));
  }
}
