package com.faishalbadri.hijab.repository.city_event;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.city.CityItem;
import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public interface EventCityDataResource {

  void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback);

  interface EventCityGetCallback {

    void onSuccesEventCity(List<CityItem> data, String msg);

    void onErrorEventCity(String msg);
  }
}
