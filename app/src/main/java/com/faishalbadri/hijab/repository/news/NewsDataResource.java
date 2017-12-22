package com.faishalbadri.hijab.repository.news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsDataResource {

  void getNewsResult(@NonNull NewsGetCallback newsGetCallback);

  void getSliderResult(@NonNull SliderGetCallback sliderGetCallback);

  interface NewsGetCallback {

    void onSuccesNews(List<NewsBean> data, String msg);

    void onErrorNews(String msg);

  }

  interface SliderGetCallback {

    void onSuccesSlider(List<NewsBean> dataSlider, String msg);

    void onErrorSlider(String msg);
  }
}
