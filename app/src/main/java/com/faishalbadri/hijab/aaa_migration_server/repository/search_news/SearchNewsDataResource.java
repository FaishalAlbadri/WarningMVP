package com.faishalbadri.hijab.aaa_migration_server.repository.search_news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchNewsDataResource {

  void getSearchNewsResult(String key, @NonNull SearchNewsGetCallback searchNewsGetCallback);

  interface SearchNewsGetCallback {

    void onSuccesSearchNews(List<PojoNews.NewsBean> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

}
