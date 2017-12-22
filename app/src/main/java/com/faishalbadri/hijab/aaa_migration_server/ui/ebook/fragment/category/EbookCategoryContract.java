package com.faishalbadri.hijab.aaa_migration_server.ui.ebook.fragment.category;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbookCategory;
import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryContract {

  public interface EbookCategoryView {

    void onSuccessCategoryEbook(List<PojoEbookCategory.EbookCategoriesBean> ebook, String msg);

    void onNullCategoryEbook(String msg);

    void onErrorCategoryEbook(String msg);

  }

  public interface EbookCategoryPresenter extends BasePresenter<EbookCategoryView> {

    void getData();

  }

}
