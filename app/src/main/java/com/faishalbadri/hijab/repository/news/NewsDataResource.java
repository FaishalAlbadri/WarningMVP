package com.faishalbadri.hijab.repository.news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsDataResource {

  interface NewsGetCallback {

    void onSuccesNews(List<PojoNews.IsiBean> data, String msg);

    void onErrorNews(String msg);
  }

  void getNewsResult(@NonNull NewsGetCallback newsGetCallback);
}
