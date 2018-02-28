package com.faishalbadri.hijab.repository.detail_news_related_;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public interface DetailNewsDataResource {

  void getDetailNewsPopularResult(String id_isi, @NonNull DetailNewsPopularGetCallback
      detailNewsPopularGetCallback);

  void getViewResult(String id_news, @NonNull viewGetCallback viewGetCallback);

  interface DetailNewsPopularGetCallback {

    void onSuccesDetailNewsPopular(List<NewsBean> data, String msg);

    void onErrorDetailNewsPopular(String msg);
  }

  interface viewGetCallback {

    void onSuccesView(List<NewsBean> data, String msg);

    void onError(String msg);
  }

}
