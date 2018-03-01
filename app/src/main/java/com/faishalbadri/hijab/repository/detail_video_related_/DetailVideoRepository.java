package com.faishalbadri.hijab.repository.detail_video_related_;

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
  public void getDetailVideo(String limit,@NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    detailVideoDataResource.getDetailVideo(limit,detailVideoGetDataCallBack);
  }
}
