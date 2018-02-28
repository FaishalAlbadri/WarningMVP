package com.faishalbadri.hijab.repository.event_by_city;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.event.EventItem;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventByCityDataResource {

  void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback);

  interface EventByCityGetCallback {

    void onSuccesEventByCity(List<EventItem> data, String msg);

    void onErrorEventByCity(String msg);
  }

}
