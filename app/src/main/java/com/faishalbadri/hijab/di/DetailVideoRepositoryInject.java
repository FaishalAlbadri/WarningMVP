package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataRepository;
import com.faishalbadri.hijab.repository.detail_video_related.remote.DetailVideoDataRemote;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoRepositoryInject {

  public static DetailVideoDataRepository provideToDetailVideoInject(Context context){
    return new DetailVideoDataRepository(new DetailVideoDataRemote(context));
  }

}
