package com.faishalbadri.hijab.repository.search_event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.event.EventItem;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public interface SearchEventDataResource {

  void getSearchEventResult(String key, @NonNull SearchEventGetCallback searchEventGetCallback);

  interface SearchEventGetCallback {

    void onSuccesSearchEvent(List<EventItem> data, String msg);

    void onWrongSearchEvent(String msg);

    void onErrorSearchEvent(String msg);
  }
}
