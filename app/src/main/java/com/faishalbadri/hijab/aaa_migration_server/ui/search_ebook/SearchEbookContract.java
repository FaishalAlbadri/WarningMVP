package com.faishalbadri.hijab.aaa_migration_server.ui.search_ebook;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbook.EbookBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookContract {

  public interface SearchEbookView {

    void onSuccesSearchEbook(List<EbookBean> data, String msg);

    void onWrongSearchEbook(String msg);

    void onErrorSearchEbook(String msg);
  }

  public interface SearchEbookPresenter extends BasePresenter<SearchEbookView> {

    void getDataSearchEbook(String key);
  }
}
