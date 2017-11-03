package com.faishalbadri.hijab.repository.video_perkat;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoPerkatRepository implements VideoPerkatDataResource{

  private VideoPerkatDataResource videoPerkatDataResource;

  public VideoPerkatRepository(VideoPerkatDataResource videoPerkatRemote) {
    this.videoPerkatDataResource = videoPerkatRemote;
  }

  @Override
  public void getAccountResult(String id,
      @NonNull VideoPerkatGetDataCallBack videoPerkatGetDataCallBack) {
    videoPerkatDataResource.getAccountResult(id, videoPerkatGetDataCallBack);
  }
}
