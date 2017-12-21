package com.faishalbadri.hijab.revamp.repository.detail_video_related;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/6/17.
 */

public class DetailVideoDataRepository implements DetailVideoDataResource {

  private DetailVideoDataResource detailVideoDataResource;

  public DetailVideoDataRepository(DetailVideoDataResource detailVideoDataResource) {
    this.detailVideoDataResource = detailVideoDataResource;
  }

  @Override
  public void getDetailVideo(String limit,@NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    detailVideoDataResource.getDetailVideo(limit,detailVideoGetDataCallBack);
  }
}
