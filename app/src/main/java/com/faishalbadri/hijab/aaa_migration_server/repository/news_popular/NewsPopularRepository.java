package com.faishalbadri.hijab.aaa_migration_server.repository.news_popular;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularRepository implements NewsPopularDataResource {

  NewsPopularDataResource newsPopularDataResource;

  public NewsPopularRepository(NewsPopularDataResource newsPopularDataResource) {
    this.newsPopularDataResource = newsPopularDataResource;
  }

  @Override
  public void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback) {
    newsPopularDataResource.getNewsPopularResult(newsPopularGetCallback);
  }
}
