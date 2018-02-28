package com.faishalbadri.hijab.repository.category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.categories.CategoriesItem;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface CategoryDataResource {

  void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback);

  interface CategoryGetCallback {

    void onSuccesCategory(List<CategoriesItem> data, String msg);

    void onErrorCategory(String msg);
  }

}
