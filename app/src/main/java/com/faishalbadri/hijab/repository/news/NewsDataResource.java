package com.faishalbadri.hijab.repository.news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.revamp.data.PojoSlider;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsDataResource {

  void getNewsResult(@NonNull NewsGetCallback newsGetCallback);

  void getSliderResult(@NonNull SliderGetCallback sliderGetCallback);

  interface NewsGetCallback {

    void onSuccesNews(List<PojoNews.IsiBean> data, String msg);

    void onErrorNews(String msg);

  }

  interface SliderGetCallback {

    void onSuccesSlider(List<PojoSlider.SliderBean> dataSlider, String msg);

    void onErrorSlider(String msg);
  }
}
