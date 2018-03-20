package com.faishalbadri.hijab.repository.ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.ebook.with_category.EbookCategoryItem;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface EbookDataResource {

  void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack);

  interface EbookGetCallBack {

    void onSuccessEbook(List<EbookCategoryItem> data, String msg);

    void onErrorEbook(String msg);

  }

}
