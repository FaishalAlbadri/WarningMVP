package com.faishalbadri.hijab.ui.search_ebook;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookContract {

  public interface SearchEbookView {

    void onSuccesSearchEbook(List<EbookBean> data,String msg);

    void onWrongSearchEbook(String msg);

    void onErrorSearchEbook(String msg);
  }

  public interface SearchEbookPresenter extends BasePresenter<SearchEbookView> {

    void getDataSearchEbook(String key);
  }
}
