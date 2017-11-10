package com.faishalbadri.hijab.repository.ebook_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbookCategory.KategoriEbookBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public interface EbookCategoryDataResource {

  interface EbookCategoryGetCallBack {

    void onSuccessCategoryEbook(List<KategoriEbookBean> data, String msg);

    void onNullCategoryEbook( String msg);

    void onErrorCategoryEbook( String msg);

  }

  void getEbookCategoryList(@NonNull EbookCategoryGetCallBack ebookCategoryGetCallBack);

}
