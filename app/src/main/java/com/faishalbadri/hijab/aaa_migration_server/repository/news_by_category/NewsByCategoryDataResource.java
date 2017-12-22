package com.faishalbadri.hijab.aaa_migration_server.repository.news_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsByCategoryDataResource {

  void getNewsByCategoryGetDataCallBack(String id,
      @NonNull NewsByCategoryDataResource.NewsByCategoryGetDataCallBack newsByCategoryGetDataCallBack);

  interface NewsByCategoryGetDataCallBack {

    void onSuccessNewsByCategory(List<PojoNews.NewsBean> video, String msg);

    void onErrorNewsByCategory(String msg);

  }

}
