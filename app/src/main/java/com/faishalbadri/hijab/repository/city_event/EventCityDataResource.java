package com.faishalbadri.hijab.repository.city_event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoCityEvent;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventCityDataResource {

  interface EventCityGetCallback {

    void onSuccesEventCity(List<PojoCityEvent.CityEventBean> data, String msg);

    void onErrorEventCity(String msg);
  }

  void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback);
}
