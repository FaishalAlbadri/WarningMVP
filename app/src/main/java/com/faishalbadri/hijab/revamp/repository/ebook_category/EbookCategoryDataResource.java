package com.faishalbadri.hijab.revamp.repository.ebook_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.revamp.data.PojoEbookCategory;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public interface EbookCategoryDataResource {

  void getEbookCategoryList(@NonNull EbookCategoryGetCallBack ebookCategoryGetCallBack);

  interface EbookCategoryGetCallBack {

    void onSuccessCategoryEbook(List<PojoEbookCategory.EbookCategoriesBean> data, String msg);

    void onNullCategoryEbook(String msg);

    void onErrorCategoryEbook(String msg);

  }

}
