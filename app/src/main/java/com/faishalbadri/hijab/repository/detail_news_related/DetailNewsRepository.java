package com.faishalbadri.hijab.repository.detail_news_related;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataResource;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsRepository implements DetailNewsDataResource {

  DetailNewsDataResource detailNewsDataResource;

  public DetailNewsRepository(DetailNewsDataResource detailNewsDataResource) {
    this.detailNewsDataResource = detailNewsDataResource;
  }

  @Override
  public void getDetailNewsPopularResult(
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    detailNewsDataResource.getDetailNewsPopularResult(detailNewsPopularGetCallback);
  }
}
