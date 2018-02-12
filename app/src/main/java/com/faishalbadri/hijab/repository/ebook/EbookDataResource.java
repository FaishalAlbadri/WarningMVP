package com.faishalbadri.hijab.repository.ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbookWithCategory;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface EbookDataResource {

  void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack);

  interface EbookGetCallBack {

    void onSuccessEbook(List<PojoEbookWithCategory.DataBean> data, String msg);

    void onErrorEbook(String msg);

  }

}
