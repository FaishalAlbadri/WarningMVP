package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.video_.VideoRepository;
import com.faishalbadri.hijab.repository.video_.remote.VideoDataRemote;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoRepositoryInject {

  public static VideoRepository provideToCategoryVideoRepositories(Context context) {
    return new VideoRepository(new VideoDataRemote(context));
  }
}
