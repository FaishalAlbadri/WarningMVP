package com.faishalbadri.hijab.repository.search_ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.ebook.EbookItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchEbookDataResource {

  void getSearchEbookResult(String key, @NonNull SearchEbookGetCallback searchEbookGetCallback);

  interface SearchEbookGetCallback {

    void onSuccesSearchEbook(List<EbookItem> data, String msg);

    void onWrongSearchEbook(String msg);

    void onErrorSearchEbook(String msg);
  }

}
