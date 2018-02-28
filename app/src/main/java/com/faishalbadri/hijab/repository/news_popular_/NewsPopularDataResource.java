package com.faishalbadri.hijab.repository.news_popular_;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsPopularDataResource {

  void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback);

  interface NewsPopularGetCallback {

    void onSuccesNewsPopular(List<NewsBean> data, String msg);

    void onErrorNewsPopular(String msg);
  }
}
