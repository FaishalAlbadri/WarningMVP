package com.faishalbadri.hijab.repository.slider_home;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 20/12/17.
 */

public class SliderHomeRepository implements SliderHomeDataResource {

  private SliderHomeDataResource sliderHomeDataResource;

  public SliderHomeRepository(
      SliderHomeDataResource sliderHomeDataResource) {
    this.sliderHomeDataResource = sliderHomeDataResource;
  }

  @Override
  public void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback) {
    sliderHomeDataResource.getSliderHomeResult(sliderHomeGetCallback);
  }
}
