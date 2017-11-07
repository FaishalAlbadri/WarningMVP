package com.faishalbadri.hijab.repository.event_by_city;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoEvent;
import com.faishalbadri.hijab.data.PojoEvent.EventBean;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventByCityDataResource {

  interface EventByCityGetCallback {

    void onSuccesEventByCity(List<EventBean> data, String msg);

    void onErrorEventByCity(String msg);
  }

  void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback);

}
