package com.faishalbadri.hijab.di;

import android.content.Context;
import com.faishalbadri.hijab.repository.city_event.EventCityRepository;
import com.faishalbadri.hijab.repository.city_event.remote.EventCityDataRemote;

/**
 * Created by faishal on 11/7/17.
 */

public class CityEventRepositoryInject {

  public static EventCityRepository provideToEventCityRepository(Context context) {
    return new EventCityRepository(new EventCityDataRemote(context));
  }
}
