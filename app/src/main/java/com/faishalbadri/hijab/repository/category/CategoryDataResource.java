package com.faishalbadri.hijab.repository.category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoCategory;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface CategoryDataResource {

  void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback);

  interface CategoryGetCallback {

    void onSuccesCategory(List<PojoCategory.KategoriBean> data, String msg);

    void onErrorCategory(String msg);
  }

}
