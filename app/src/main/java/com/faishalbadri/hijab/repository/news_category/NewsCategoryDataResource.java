package com.faishalbadri.hijab.repository.news_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoCategory;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsCategoryDataResource {

  interface NewsCategoryGetCallback {

    void onSuccesNewsCategory(List<PojoCategory.KategoriBean> data, String msg);

    void onErrorNewsCategory(String msg);
  }

  void getNewsCategoryResult(@NonNull NewsCategoryGetCallback newsCategoryGetCallback);

}
