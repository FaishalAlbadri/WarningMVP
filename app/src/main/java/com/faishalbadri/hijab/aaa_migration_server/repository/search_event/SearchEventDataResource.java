package com.faishalbadri.hijab.aaa_migration_server.repository.search_event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoEvent.EventBean;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchEventDataResource {

  void getSearchEventResult(String key, @NonNull SearchEventGetCallback searchEventGetCallback);

  interface SearchEventGetCallback {

    void onSuccesSearchEvent(List<EventBean> data, String msg);

    void onWrongSearchEvent(String msg);

    void onErrorSearchEvent(String msg);
  }
}
