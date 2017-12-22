package com.faishalbadri.hijab.aaa_migration_server.repository.news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsDataResource {

  void getNewsResult(@NonNull NewsGetCallback newsGetCallback);

  void getSliderResult(@NonNull SliderGetCallback sliderGetCallback);

  interface NewsGetCallback {

    void onSuccesNews(List<PojoNews.NewsBean> data, String msg);

    void onErrorNews(String msg);

  }

  interface SliderGetCallback {

    void onSuccesSlider(List<PojoNews.NewsBean> dataSlider, String msg);

    void onErrorSlider(String msg);
  }
}
