package com.faishalbadri.hijab.aaa_migration_server.repository.search_ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbook;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchEbookDataResource {

  void getSearchEbookResult(String key, @NonNull SearchEbookGetCallback searchEbookGetCallback);

  interface SearchEbookGetCallback {

    void onSuccesSearchEbook(List<PojoEbook.EbookBean> data, String msg);

    void onWrongSearchEbook(String msg);

    void onErrorSearchEbook(String msg);
  }

}
