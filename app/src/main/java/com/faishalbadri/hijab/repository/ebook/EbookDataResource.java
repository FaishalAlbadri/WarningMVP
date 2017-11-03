package com.faishalbadri.hijab.repository.ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbook;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface EbookDataResource {

  interface EbookGetCallBack {

    void onSuccessEbook(List<PojoEbook.EbookBean> data, String msg);

    void onNullEbook( String msg);

    void onErrorEbook( String msg);

  }

  void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack);

}
