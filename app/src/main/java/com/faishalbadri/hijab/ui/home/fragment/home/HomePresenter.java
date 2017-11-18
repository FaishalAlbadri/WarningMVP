package com.faishalbadri.hijab.ui.home.fragment.home;

import com.faishalbadri.hijab.data.PojoSlider.SliderBean;
import com.faishalbadri.hijab.repository.news.NewsDataResource.SliderGetCallback;
import com.faishalbadri.hijab.repository.news.NewsRepository;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeContract.homeView;
import java.util.List;

/**
 * Created by faishal on 17/11/17.
 */

public class HomePresenter implements HomeContract.homePresenter {

  HomeContract.homeView homeView;
  NewsRepository newsRepository;

  public HomePresenter(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
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
    newsRepository.getSliderResult(new SliderGetCallback() {
      @Override
      public void onSuccesSlider(List<SliderBean> dataSlider, String msg) {
        homeView.onSuccesSlider(dataSlider, msg);
      }

      @Override
      public void onErrorSlider(String msg) {
        homeView.onErrorSlider(msg);
      }
    });
  }
}
