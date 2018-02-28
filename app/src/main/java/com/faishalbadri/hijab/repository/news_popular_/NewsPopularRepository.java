package com.faishalbadri.hijab.repository.news_popular_;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsPopularRepository implements NewsPopularDataResource {

  private NewsPopularDataResource newsPopularDataResource;

  public NewsPopularRepository(NewsPopularDataResource newsPopularDataResource) {
    this.newsPopularDataResource = newsPopularDataResource;
  }

  @Override
  public void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback) {
    newsPopularDataResource.getNewsPopularResult(newsPopularGetCallback);
  }
}
