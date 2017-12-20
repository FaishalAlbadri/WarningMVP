package com.faishalbadri.hijab.revamp.repository.slider_home;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.revamp.data.PojoSlider.SliderBean;
import java.util.List;

/**
 * Created by faishal on 20/12/17.
 */

public interface SliderHomeDataResource {

  void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback);

  interface SliderHomeGetCallback {

    void onSuccesSliderHome(List<SliderBean> data, String msg);

    void onErrorSliderHome(String msg);
  }

}
