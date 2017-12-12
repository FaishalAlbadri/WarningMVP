package com.faishalbadri.hijab.repository.detail_news_related;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/8/17.
 */

public interface DetailNewsDataResource {

  void getDetailNewsPopularResult(String id_isi,@NonNull DetailNewsPopularGetCallback
      detailNewsPopularGetCallback);

  interface DetailNewsPopularGetCallback {

    void onSuccesDetailNewsPopular(List<IsiBean> data, String msg);

    void onErrorDetailNewsPopular(String msg);
  }

}
