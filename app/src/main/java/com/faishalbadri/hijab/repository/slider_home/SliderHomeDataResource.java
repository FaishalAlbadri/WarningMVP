package com.faishalbadri.hijab.repository.slider_home;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.slider.SliderItem;
import java.util.List;

/**
 * Created by faishal on 20/12/17.
 */

public interface SliderHomeDataResource {

  void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback);

  interface SliderHomeGetCallback {

    void onSuccesSliderHome(List<SliderItem> data, String msg);

    void onErrorSliderHome(String msg);
  }

}
