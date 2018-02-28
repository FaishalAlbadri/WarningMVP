package com.faishalbadri.hijab.repository.video_by_category_;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class VideoByCategoryRepository implements VideoByCategoryDataResource {

  private VideoByCategoryDataResource videoByCategoryDataResource;

  public VideoByCategoryRepository(
      VideoByCategoryDataResource videoByCategoryDataResource) {
    this.videoByCategoryDataResource = videoByCategoryDataResource;
  }

  @Override
  public void getVideoByCategoryGetDataCallBack(String id,
      @NonNull VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack) {
    videoByCategoryDataResource
        .getVideoByCategoryGetDataCallBack(id, videoByCategoryGetDataCallBack);
  }
}
