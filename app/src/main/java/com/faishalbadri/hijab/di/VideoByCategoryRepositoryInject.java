package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.video_by_category_.VideoByCategoryRepository;
import com.faishalbadri.hijab.repository.video_by_category_.remote.VideoByCategoryRemote;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoByCategoryRepositoryInject {

  public static VideoByCategoryRepository provideToVideoByCategoryRepository(Context context) {
    return new VideoByCategoryRepository(new VideoByCategoryRemote(context));
  }
}
