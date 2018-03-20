package com.faishalbadri.hijab.repository.news_popular;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.news.NewsItem;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsPopularDataResource {

  void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback);

  interface NewsPopularGetCallback {

    void onSuccesNewsPopular(List<NewsItem> data, String msg);

    void onErrorNewsPopular(String msg);
  }
}
