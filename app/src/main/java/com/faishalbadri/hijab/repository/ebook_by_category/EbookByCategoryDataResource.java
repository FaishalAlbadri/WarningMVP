package com.faishalbadri.hijab.repository.ebook_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public interface EbookByCategoryDataResource {

  interface EbookByCategoryDataCallBack{

    void onSuccessEbookByCategory(List<EbookBean> video, String msg);

    void onErrorEbookByCategory(String msg);

  }

  void getByCategoryGetDataCallBack(String id, @NonNull EbookByCategoryDataResource.EbookByCategoryDataCallBack newsByCategoryGetDataCallBack);

}
