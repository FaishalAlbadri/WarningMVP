package com.faishalbadri.hijab.revamp.ui.home.fragment.home;

import com.faishalbadri.hijab.revamp.data.PojoSlider.SliderBean;
import com.faishalbadri.hijab.revamp.repository.slider_home.SliderHomeDataResource.SliderHomeGetCallback;
import com.faishalbadri.hijab.revamp.repository.slider_home.SliderHomeRepository;
import com.faishalbadri.hijab.revamp.ui.home.fragment.home.HomeContract.homeView;
import java.util.List;

/**
 * Created by faishal on 17/11/17.
 */

public class HomePresenter implements HomeContract.homePresenter {

  HomeContract.homeView homeView;
  SliderHomeRepository sliderHomeRepository;

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
      public void onSuccesSliderHome(List<SliderBean> data, String msg) {
        homeView.onSuccesSlider(data, msg);
      }

      @Override
      public void onErrorSliderHome(String msg) {
        homeView.onErrorSlider(msg);
      }
    });
  }
}
