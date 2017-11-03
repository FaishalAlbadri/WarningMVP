package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.video_perkat.VideoPerkatRepository;
import com.faishalbadri.hijab.repository.video_perkat.remote.VideoPerkatRemote;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoPerkatRepositoryInject {
  public static VideoPerkatRepository provideToLoginRepository(Context context){
    return new VideoPerkatRepository(new VideoPerkatRemote(context));
  }
}
