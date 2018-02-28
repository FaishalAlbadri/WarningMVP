package com.faishalbadri.hijab.ui.home.fragment.home;

import com.faishalbadri.hijab.data.slider.SliderItem;
import com.faishalbadri.hijab.repository.slider_home.SliderHomeDataResource.SliderHomeGetCallback;
import com.faishalbadri.hijab.repository.slider_home.SliderHomeRepository;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeContract.homeView;
import java.util.List;

/**
 * Created by faishal on 17/11/17.
 */

public class HomePresenter implements HomeContract.homePresenter {

  private HomeContract.homeView homeView;
  private SliderHomeRepository sliderHomeRepository;

  public HomePresenter(
      SliderHomeRepository sliderHomeRepository) {
    this.sliderHomeRepository = sliderHomeRepository;
  }

  @Override
  public void onAttachView(homeView view) {
    this.homeView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSlider() {
    sliderHomeRepository.getSliderHomeResult(new SliderHomeGetCallback() {
      @Override
      public void onSuccesSliderHome(List<SliderItem> data, String msg) {
        homeView.onSuccesSlider(data, msg);
      }

      @Override
      public void onErrorSliderHome(String msg) {
        homeView.onErrorSlider(msg);
      }
    });
  }
}
