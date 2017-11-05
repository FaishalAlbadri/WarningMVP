package com.faishalbadri.hijab.repository.news_popular;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsPopularDataResource {

  interface NewsPopularGetCallback {

    void onSuccesNewsPopular(List<PojoNews.IsiBean> data, String msg);

    void onErrorNewsPopular(String msg);
  }

  void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback);
}
