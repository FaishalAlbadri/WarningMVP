package com.faishalbadri.hijab.ui.ebook_by_category;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.ebook.EbookItem;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryContract {

  public interface ebookByCategoryView {

    void onSuccesEbookByCategory(List<EbookItem> data, String msg);

    void onErrorEbookByCategory(String msg);
  }

  public interface EbookByCategoryPresenter extends BasePresenter<ebookByCategoryView> {

    void getDataEbookByCategory(String id);
  }

}
