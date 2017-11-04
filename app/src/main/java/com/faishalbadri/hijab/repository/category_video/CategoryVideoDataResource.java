package com.faishalbadri.hijab.repository.category_video;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public interface CategoryVideoDataResource {

  interface CategoryVideoGetCallBack {

    void onSuccessCategoryVideo(List<EbookBean> data, String msg);

    void onErrorCategoryVideo( String msg);

  }

  void getCategoryVideoList(@NonNull CategoryVideoGetCallBack CategoryVideoGetCallBack);

}
