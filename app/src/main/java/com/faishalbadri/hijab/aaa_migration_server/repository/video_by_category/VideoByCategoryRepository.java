package com.faishalbadri.hijab.aaa_migration_server.repository.video_by_category;

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
