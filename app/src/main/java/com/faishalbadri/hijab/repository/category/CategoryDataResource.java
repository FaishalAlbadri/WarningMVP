package com.faishalbadri.hijab.repository.category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoCategory.CategoriesBean;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface CategoryDataResource {

  void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback);

  interface CategoryGetCallback {

    void onSuccesCategory(List<CategoriesBean> data, String msg);

    void onErrorCategory(String msg);
  }

}
