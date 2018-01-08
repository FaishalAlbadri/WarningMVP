package com.faishalbadri.hijab.repository.detail_news_related;

import android.support.annotation.NonNull;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public class DetailNewsRepository implements DetailNewsDataResource {

  DetailNewsDataResource detailNewsDataResource;

  public DetailNewsRepository(DetailNewsDataResource detailNewsDataResource) {
    this.detailNewsDataResource = detailNewsDataResource;
  }

  @Override
  public void getDetailNewsPopularResult(String id_isi,
      @NonNull DetailNewsPopularGetCallback detailNewsPopularGetCallback) {
    detailNewsDataResource.getDetailNewsPopularResult(id_isi,detailNewsPopularGetCallback);
  }

  @Override
  public void getViewResult(String id_news, @NonNull viewGetCallback viewGetCallback) {
    detailNewsDataResource.getViewResult(id_news, viewGetCallback);
  }
}
