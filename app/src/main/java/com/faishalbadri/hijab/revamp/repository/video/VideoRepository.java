package com.faishalbadri.hijab.revamp.repository.video;

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
  public void getVideoList(@NonNull VideoGetCallBack videoGetCallBack) {
    videoDataResource.getVideoList(videoGetCallBack);
  }
}
