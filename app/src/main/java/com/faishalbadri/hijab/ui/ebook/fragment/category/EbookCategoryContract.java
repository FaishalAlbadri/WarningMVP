package com.faishalbadri.hijab.ui.ebook.fragment.category;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoEbookCategory.KategoriEbookBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryContract {

  public interface EbookCategoryView {

    void onSuccessCategoryEbook(List<KategoriEbookBean> ebook, String msg);

    void onNullCategoryEbook(String msg);

    void onErrorCategoryEbook(String msg);

  }

  public interface EbookCategoryPresenter extends BasePresenter<EbookCategoryView> {

    void getData();

  }

}
