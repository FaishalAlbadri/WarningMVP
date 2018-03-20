package com.faishalbadri.hijab.repository.detail_video_related;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoRepository implements DetailVideoDataResource {

  private DetailVideoDataResource detailVideoDataResource;

  public DetailVideoRepository(DetailVideoDataResource detailVideoDataResource) {
    this.detailVideoDataResource = detailVideoDataResource;
  }

  @Override
  public void getDetailVideo(@NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    detailVideoDataResource.getDetailVideo(detailVideoGetDataCallBack);
  }
}
