package com.faishalbadri.hijab.repository.video_;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoRepository implements VideoDataResource {

  private VideoDataResource videoDataResource;

  public VideoRepository(VideoDataResource videoDataResource) {
    this.videoDataResource = videoDataResource;
  }

  @Override
  public void getVideoList(int PAGE,@NonNull VideoGetCallBack videoGetCallBack) {
    videoDataResource.getVideoList(PAGE,videoGetCallBack);
  }
}
