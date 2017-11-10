package com.faishalbadri.hijab.repository.search_ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbook;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchEbookDataResource {

  interface SearchEbookGetCallback {

    void onSuccesSearchEbook(List<PojoEbook.EbookBean> data, String msg);

    void onWrongSearchEbook(String msg);

    void onErrorSearchEbook(String msg);
  }

  void getSearchEbookResult(String key , @NonNull SearchEbookGetCallback searchEbookGetCallback);

}
