package com.faishalbadri.hijab.ui.home.fragment.home;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.slider.SliderItem;
import java.util.List;

/**
 * Created by faishal on 17/11/17.
 */

public class HomeContract {

  public interface homeView {

    void onSuccesSlider(List<SliderItem> dataSlider, String msg);

    void onErrorSlider(String msg);

  }

  public interface homePresenter extends BasePresenter<homeView> {

    void getDataSlider();

  }

}
