package com.faishalbadri.hijab.repository.search_news_;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchNewsDataResource {

  void getSearchNewsResult(String key, @NonNull SearchNewsGetCallback searchNewsGetCallback);

  interface SearchNewsGetCallback {

    void onSuccesSearchNews(List<NewsBean> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

}
