package com.faishalbadri.hijab.repository.news;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsRepository implements NewsDataResource {

  NewsDataResource newsDataResource;

  public NewsRepository(NewsDataResource newsDataResource) {
    this.newsDataResource = newsDataResource;
  }

  @Override
  public void getNewsResult(@NonNull NewsGetCallback newsGetCallback) {
    newsDataResource.getNewsResult(newsGetCallback);
  }
}
