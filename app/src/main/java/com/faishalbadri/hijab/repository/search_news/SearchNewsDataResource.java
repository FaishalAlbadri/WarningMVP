package com.faishalbadri.hijab.repository.search_news;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchNewsDataResource {

  interface SearchNewsGetCallback {

    void onSuccesSearchNews(List<IsiBean> data, String msg);

    void onWrongSearchNews(String msg);

    void onErrorSearchNews(String msg);
  }

  void getSearchNewsResult(String key , @NonNull SearchNewsGetCallback searchNewsGetCallback);

}