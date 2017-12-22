package com.faishalbadri.hijab.aaa_migration_server.repository.detail_news_related;

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
}
