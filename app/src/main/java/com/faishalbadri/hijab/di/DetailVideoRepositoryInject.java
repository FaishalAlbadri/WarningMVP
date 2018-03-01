package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.detail_video_related_.DetailVideoRepository;
import com.faishalbadri.hijab.repository.detail_video_related_.remote.DetailVideoDataRemote;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoRepositoryInject {

  public static DetailVideoRepository provideToDetailVideoInject(Context context) {
    return new DetailVideoRepository(new DetailVideoDataRemote(context));
  }

}
