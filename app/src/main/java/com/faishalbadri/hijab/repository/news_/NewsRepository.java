package com.faishalbadri.hijab.repository.news_;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsRepository implements NewsDataResource {

  private NewsDataResource newsDataResource;

  public NewsRepository(NewsDataResource newsDataResource) {
    this.newsDataResource = newsDataResource;
  }

  @Override
  public void getNewsResult(int PAGE, @NonNull NewsGetCallback newsGetCallback) {
    newsDataResource.getNewsResult(PAGE, newsGetCallback);
  }

  @Override
  public void getSliderResult(@NonNull SliderGetCallback sliderGetCallback) {
    newsDataResource.getSliderResult(sliderGetCallback);
  }
}
