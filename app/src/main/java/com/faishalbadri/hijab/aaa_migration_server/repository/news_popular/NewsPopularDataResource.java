package com.faishalbadri.hijab.aaa_migration_server.repository.news_popular;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsPopularDataResource {

  void getNewsPopularResult(@NonNull NewsPopularGetCallback newsPopularGetCallback);

  interface NewsPopularGetCallback {

    void onSuccesNewsPopular(List<PojoNews.NewsBean> data, String msg);

    void onErrorNewsPopular(String msg);
  }
}
