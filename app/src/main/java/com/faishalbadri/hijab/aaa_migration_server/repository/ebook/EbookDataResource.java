package com.faishalbadri.hijab.aaa_migration_server.repository.ebook;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbook;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public interface EbookDataResource {

  void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack);

  interface EbookGetCallBack {

    void onSuccessEbook(List<PojoEbook.EbookBean> data, String msg);

    void onNullEbook(String msg);

    void onErrorEbook(String msg);

  }

}
